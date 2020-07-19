package kz.cb.spring.lesson7;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("singerValidator")
public class SingerValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Singer.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "firstName", "firstName.empty");
        ValidationUtils.rejectIfEmpty(e, "lastName", "lastName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e,"firstName","firstName.rejectIfEmptyOrWhitespace");



    }
}
