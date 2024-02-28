package kz.agro.agrofarm.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import kz.agro.agrofarm.model.annotation.Age;
import kz.agro.agrofarm.model.annotation.PhoneNumber;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author inspiredsamat
 * @portfolio <a href="https://inspiredsamat.github.io">Personal portfolio</a>
 */

@Getter
@Setter
public class SignUpRequest {

    @NotBlank(message = "Name can not be blank")
    private String name;

    @NotBlank(message = "Lastname can not be blank")
    private String lastName;

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
