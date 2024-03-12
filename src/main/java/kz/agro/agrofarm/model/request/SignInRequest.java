package kz.agro.agrofarm.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Samat Zhumamuratov
 */

@Getter
@Setter
public class SignInRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
