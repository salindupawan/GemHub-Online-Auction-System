package lk.gemhub.project.repositary;

import jakarta.ejb.Singleton;
import lk.gemhub.project.model.User;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class UserRepo {
    private List<User> users;

    public UserRepo() {
        users = new ArrayList<User>();
        users.add(new User(1,"salindu","123","user@gmail.com","0786655444","user"));
        users.add(new User(2,"pawan","123","user1@gmail.com","0782655444","user"));
        users.add(new User(3,"admin","123","admin@gmail.com","0782655444","admin"));
    }
    public List<User> getUsers() {
        return users;
    }
    public boolean findUserByEmail(String email) {
        boolean found = false;

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                found = true;
                break;
            }
        }
        return found;
    }
    public User findUserByEmailAndPassword(String email, String password) {
        User found = null;
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                found = user;
                break;

            }
        }
        return found;
    }
    public void addUser(User user) {
        users.add(user);
    }
    public int getCount() {
        return users.size();
    }
}
