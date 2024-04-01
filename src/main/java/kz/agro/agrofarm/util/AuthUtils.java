package kz.agro.agrofarm.util;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Samat Zhumamuratov
 */

public class AuthUtils {

    public static String getLoggedInUserEmail() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
