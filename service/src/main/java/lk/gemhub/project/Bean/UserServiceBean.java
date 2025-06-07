package lk.gemhub.project.Bean;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import lk.gemhub.project.dto.UserDTO;
import lk.gemhub.project.model.User;
import lk.gemhub.project.remote.UserService;
import lk.gemhub.project.repositary.UserRepo;
import lk.gemhub.project.validation.UserValidator;

import java.util.Random;

@Stateless
public class UserServiceBean implements UserService {

    @EJB
    private UserRepo userRepo;

    @Inject
    private UserValidator userValidator;

    @Override
    public boolean registerUser(UserDTO userDTO) {

        if(userValidator.validate(userDTO).equals("valid")) {

            if(!userRepo.findUserByEmail(userDTO.getEmail())){
                User user = new User(new Random().nextInt(100000), userDTO.getName(), userDTO.getPassword(), userDTO.getEmail(), userDTO.getPhone(),userDTO.getType());
                userRepo.addUser(user);
                return true;

            }else{
                System.out.println("User already exists");
                return false;
            }
        }else {
            System.out.println(userValidator.validate(userDTO));
            return false;
        }



    }

    @Override
    public User authenticateUser(String email, String password) {
        User user = userRepo.findUserByEmailAndPassword(email, password);
        return user;

    }
}
