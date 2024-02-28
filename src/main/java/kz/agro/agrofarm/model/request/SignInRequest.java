package kz.agro.agrofarm.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @author inspiredsamat
 * @portfolio <a href="https://inspiredsamat.github.io">Personal portfolio</a>
 */

@Getter
@Setter
public class SignInRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
