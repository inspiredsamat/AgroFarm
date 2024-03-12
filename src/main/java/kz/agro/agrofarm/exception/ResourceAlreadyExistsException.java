package kz.agro.agrofarm.exception;

/**
 * @author Samat Zhumamuratov
 */

public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
