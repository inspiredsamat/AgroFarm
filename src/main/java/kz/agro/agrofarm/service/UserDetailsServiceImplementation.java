package kz.agro.agrofarm.service;

import kz.agro.agrofarm.entity.User;
import kz.agro.agrofarm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Samat Zhumamuratov
 */

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImplementation implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found"));

        return new UserDetailsImplementation(user);
    }
}
