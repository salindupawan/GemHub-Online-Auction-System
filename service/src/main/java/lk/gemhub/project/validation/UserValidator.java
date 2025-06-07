package lk.gemhub.project.validation;

import jakarta.enterprise.context.ApplicationScoped;
import lk.gemhub.project.dto.UserDTO;
import lk.gemhub.project.model.User;

@ApplicationScoped
public class UserValidator {

    public String validate(UserDTO user) {
        if(user.getName().isEmpty()){
            return "User name is empty";
        }else if(user.getEmail().isEmpty()){
            return "User email is empty";
        } else if (user.getPhone().isEmpty()) {
            return "Phone number is empty";
        }else if(user.getPassword().isEmpty()) {
            return "User password is empty";
        }else if(!user.getPassword().equals(user.getConfirmPassword())) {
            return "User password doesn't match";
        }else{
            return "valid";
        }

    }

    public boolean isvalid(User user) {
        return true;
    }
}
