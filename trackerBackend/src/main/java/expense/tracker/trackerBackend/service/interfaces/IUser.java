package expense.tracker.trackerBackend.service.interfaces;

import expense.tracker.trackerBackend.entities.User;
import java.util.List;

public interface IUser {
    User registerUser(User user);
    //boolean login(String email, String password);
    //List<User> getAllUsers();
}
