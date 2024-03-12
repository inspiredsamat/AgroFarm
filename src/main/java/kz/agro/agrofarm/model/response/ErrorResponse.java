package kz.agro.agrofarm.model.response;

import java.time.Instant;

/**
 * @author Samat Zhumamuratov
 */

public record ErrorResponse(
        int code,
        String message,
        Instant timestamp
) {
}
