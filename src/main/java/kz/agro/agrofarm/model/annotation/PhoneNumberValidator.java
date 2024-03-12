package kz.agro.agrofarm.model.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * @author Samat Zhumamuratov
 */

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        return Pattern.matches("\\+77\\d{9}", phoneNumber);
    }
}
