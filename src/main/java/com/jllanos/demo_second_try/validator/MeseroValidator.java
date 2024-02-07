package com.jllanos.demo_second_try.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jllanos.demo_second_try.models.Mesero;



@Component
public class MeseroValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Mesero.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Mesero mesero = (Mesero) target;

        validatePassword(mesero, errors);
    }

    private void validatePassword(Mesero mesero, Errors errors) {
        if(!mesero.getPasswordConfirmation().equals(mesero.getPassword())){
            errors.rejectValue("passwordConfirmation", "Match");
        }
    }
    
}
