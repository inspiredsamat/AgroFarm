package kz.agro.agrofarm.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import kz.agro.agrofarm.model.annotation.Age;
import kz.agro.agrofarm.model.annotation.PhoneNumber;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * @author Samat Zhumamuratov
 */

@Getter
@Setter
@ToString
public class SignUpRequest {

    @NotBlank(message = "Name can not be blank")
    private String name;

    @NotBlank(message = "Lastname can not be blank")
    private String lastname;

    @Email(message = "Valid email should be provided")
    @NotBlank(message = "Email can not be blank")
    private String email;

    @NotBlank(message = "Password can not be blank")
    private String password;

    @Age
    private LocalDate birthday;

    @NotBlank(message = "Name can not be blank")
    @PhoneNumber
    private String phoneNumber;
}
