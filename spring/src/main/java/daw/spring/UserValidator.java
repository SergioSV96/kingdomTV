package daw.spring;

import daw.spring.entities.TypeUser;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator
{

    @Override
    public boolean supports(Class clazz) {
        //just validate the Customer instances
        return TypeUser.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
                "required.userName", "Field name is required.");

    }

}
