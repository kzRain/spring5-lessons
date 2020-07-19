package kz.cb.spring.lesson7;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
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

        Singer singer=(Singer)obj;
        if (singer!=null){
            System.out.println(" **" + singer.getLastName());
            if (singer.getLastName().length() > 1 || singer.getLastName().length() <20){
                e.rejectValue("lastName", "lastName.length 1-20");
                System.out.println(" lenth error");
            }
        }


    }
}
