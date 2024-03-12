package kz.agro.agrofarm.service;

import kz.agro.agrofarm.entity.User;
import kz.agro.agrofarm.model.ERole;
import kz.agro.agrofarm.model.request.SignUpRequest;
import kz.agro.agrofarm.repository.RoleRepository;
import kz.agro.agrofarm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Samat Zhumamuratov
 */

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;


    public Boolean alreadyExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public User save(SignUpRequest signUpRequest) {
        User userToSave = User.builder()
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .roles(List.of(roleRepository.findByName(ERole.ROLE_USER)))
                .name(signUpRequest.getName())
                .lastName(signUpRequest.getLastName())
                .birthday(signUpRequest.getBirthday())
                .phoneNumber(signUpRequest.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return userRepository.save(userToSave);
    }
}
