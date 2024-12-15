package expense.tracker.trackerBackend.service.implement;

import expense.tracker.trackerBackend.entities.User;
import expense.tracker.trackerBackend.dao.UserRepository;
import expense.tracker.trackerBackend.service.interfaces.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImplement implements IUser {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

   // @Override
   // public boolean login(String email, String password) {
       // User user = userRepository.findByEmail(email);
       // if (user != null && user.getPassword().equals(password)) { // Compare plaintext for simplicity
          //  return true;
       // }
       // return false;
    //}
}
