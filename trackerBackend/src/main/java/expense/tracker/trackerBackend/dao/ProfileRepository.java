package expense.tracker.trackerBackend.dao;

import expense.tracker.trackerBackend.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    // Update the query method to use 'users' instead of 'userId'
    List<Profile> findByUserId(Long userId);
}
