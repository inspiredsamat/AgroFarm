package kz.agro.agrofarm.model.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * @author inspiredsamat
 * @portfolio <a href="https://inspiredsamat.github.io">Personal portfolio</a>
 */

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        return Pattern.matches("\\+77\\d{9}", phoneNumber);
    }
}
