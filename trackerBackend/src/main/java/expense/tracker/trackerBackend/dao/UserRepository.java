package expense.tracker.trackerBackend.dao;

import expense.tracker.trackerBackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom queries here if needed
    User findByEmail(String email);
}
