package kz.agro.agrofarm.model.response;

import java.time.Instant;

/**
 * @author inspiredsamat
 * @portfolio <a href="https://inspiredsamat.github.io">Personal portfolio</a>
 */

public record ErrorResponse(
        int code,
        String message,
        Instant timestamp
) {
}
