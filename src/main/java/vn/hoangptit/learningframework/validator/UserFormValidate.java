package vn.hoangptit.learningframework.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vn.hoangptit.learningframework.dto.AccountDto;

/**
 * author Hoangptit
 * Date 9/10/2016
 */
public class UserFormValidate implements Validator {


    @Autowired
    @Qualifier("emailValidator")
    EmailValidator emailValidator;
    @Override
    public boolean supports(Class<?> clazz) {
        return AccountDto.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AccountDto account = (AccountDto)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.userForm.address");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","NotEmpty.userForm.confirmPassword");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "NotEmpty.userForm.sex");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty.userForm.country");


        /*if (!account.getPassword().equals(account.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "Diff.userform.confirmPassword");
        }

        if (user.getFramework() == null || user.getFramework().size() < 2) {
            errors.rejectValue("framework", "Valid.userForm.framework");
        }

        if (user.getSkill() == null || user.getSkill().size() < 3) {
            errors.rejectValue("skill", "Valid.userForm.skill");
        }*/
    }
}
