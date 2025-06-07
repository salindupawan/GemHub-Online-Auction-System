package lk.gemhub.project.remote;

import jakarta.ejb.Remote;
import lk.gemhub.project.dto.UserDTO;
import lk.gemhub.project.model.User;

@Remote
public interface UserService {

    public boolean registerUser(UserDTO user);
    public User authenticateUser(String email, String password);

}
