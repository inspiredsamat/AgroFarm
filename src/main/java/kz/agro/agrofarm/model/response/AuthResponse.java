package kz.agro.agrofarm.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Samat Zhumamuratov
 */

@Getter
@Setter
@Builder
public class AuthResponse {

    private String accessToken;
    private String refreshToken;
}
