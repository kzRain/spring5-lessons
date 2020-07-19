package kz.cb.spring.lesson7;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import kz.cb.spring.lesson7.obj.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("singerValidationService")
public class SingerValidationService {
    @Autowired
    private Validator validator;

    public Set<ConstraintViolation<Singer>> validateSinger(Singer singer) {
        return validator.validate(singer);
    }
}
