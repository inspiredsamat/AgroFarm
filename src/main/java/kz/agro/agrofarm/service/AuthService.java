package kz.agro.agrofarm.service;

import kz.agro.agrofarm.entity.User;
import kz.agro.agrofarm.exception.ResourceAlreadyExistsException;
import kz.agro.agrofarm.model.TokenType;
import kz.agro.agrofarm.model.request.SignInRequest;
import kz.agro.agrofarm.model.request.SignUpRequest;
import kz.agro.agrofarm.model.response.AuthResponse;
import kz.agro.agrofarm.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author Samat Zhumamuratov
 */

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    private final JwtUtils jwtUtils;

    public AuthResponse login(SignInRequest signInRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    signInRequest.getEmail(),
                    signInRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.getTokenByType(TokenType.ACCESS, signInRequest.getEmail());
        String refreshToken = jwtUtils.getTokenByType(TokenType.REFRESH, signInRequest.getEmail());

        return AuthResponse
                .builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthResponse saveUser(SignUpRequest signUpRequest) {
        if (userService.alreadyExists(signUpRequest.getEmail())) {
            throw new ResourceAlreadyExistsException("User with email " + signUpRequest.getEmail() + " already exists");
        }

        User user = userService.save(signUpRequest);

        String accessToken = jwtUtils.getTokenByType(TokenType.ACCESS, user.getEmail());
        String refreshToken = jwtUtils.getTokenByType(TokenType.REFRESH, user.getEmail());

        return AuthResponse
                .builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
