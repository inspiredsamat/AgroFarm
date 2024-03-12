package kz.agro.agrofarm.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Samat Zhumamuratov
 */

@Configuration
@ConfigurationProperties("application.security.jwt")
@Getter
@Setter
public class SecurityProperties {

    /**
     *   Secret key for signing token.
     */
    private String secretKey;

    /**
     * Expiration time of access token in milliseconds
     */
    private long accessTokenExpirationTime;

    /**
     * Expiration time of refresh token in milliseconds
     */
    private long refreshTokenExpirationTime;
}
