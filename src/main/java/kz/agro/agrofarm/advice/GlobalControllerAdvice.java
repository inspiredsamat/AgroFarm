package kz.agro.agrofarm.advice;

import kz.agro.agrofarm.exception.ResourceAlreadyExistsException;
import kz.agro.agrofarm.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

/**
 * @author Samat Zhumamuratov
 */

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage(), Instant.now());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(MethodArgumentNotValidException ex) {
        ObjectError error = ex.getBindingResult().getAllErrors().get(0);
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), error.getDefaultMessage(), Instant.now());
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleBadCredentialsException() {
        return new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), "Incorrect email or password", Instant.now());
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleAllExceptions(Exception ex) {
        return new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), ex.getMessage(), Instant.now());
    }
}
