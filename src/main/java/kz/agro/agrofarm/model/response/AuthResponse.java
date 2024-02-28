package kz.agro.agrofarm.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author inspiredsamat
 * @portfolio <a href="https://inspiredsamat.github.io">Personal portfolio</a>
 */

@Getter
@Setter
@Builder
public class AuthResponse {

    private String accessToken;
    private String refreshToken;
}
