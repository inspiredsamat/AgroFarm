package kz.agro.agrofarm.controller;

import jakarta.validation.Valid;
import kz.agro.agrofarm.model.request.SignInRequest;
import kz.agro.agrofarm.model.request.SignUpRequest;
import kz.agro.agrofarm.model.response.AuthResponse;
import kz.agro.agrofarm.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Samat Zhumamuratov
 */

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid SignInRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid SignUpRequest request) {
        return ResponseEntity.ok(authService.saveUser(request));
    }
}
