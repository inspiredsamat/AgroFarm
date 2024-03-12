package kz.agro.agrofarm.exception;

/**
 * @author Samat Zhumamuratov
 */

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
