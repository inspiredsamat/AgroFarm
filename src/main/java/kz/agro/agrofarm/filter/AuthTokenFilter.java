package kz.agro.agrofarm.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.agro.agrofarm.service.UserDetailsServiceImplementation;
import kz.agro.agrofarm.util.JwtUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author Samat Zhumamuratov
 */

@Component
@RequiredArgsConstructor
public class AuthTokenFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    private final UserDetailsServiceImplementation userDetailsServiceImplementation;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String email = null;
        String jwt;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            email = jwtUtils.getEmail(jwt);
        }
        if (email != null && SecurityContextHolder.getContext().getAuthentication() != null) {
            UserDetails userDetails = userDetailsServiceImplementation.loadUserByUsername(email);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    email,
                    null,
                    userDetails.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        filterChain.doFilter(request, response);
    }
}
