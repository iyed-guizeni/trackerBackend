package expense.tracker.trackerBackend.dao;

import expense.tracker.trackerBackend.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Fetch notifications for a specific profile
    List<Notification> findByProfileId(Long profileId);

    // Optionally: Fetch only unsent notifications for a profile
    List<Notification> findByProfileIdAndSentFalse(Long profileId);
}
