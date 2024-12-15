package expense.tracker.trackerBackend.service.implement;

import expense.tracker.trackerBackend.dao.NotificationRepository;
import expense.tracker.trackerBackend.dao.ProfileRepository;
import expense.tracker.trackerBackend.entities.Notification;
import expense.tracker.trackerBackend.entities.Profile;
import expense.tracker.trackerBackend.service.interfaces.INotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationImplement implements INotification {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void createNotification(String message, Long profileId) {
        // Find the profile by ID
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        // Create a new notification for the profile
        Notification notification = new Notification(message, profile);

        // Save the notification
        notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getNotificationsByProfileId(Long profileId) {
        // Retrieve notifications for the profile
        return notificationRepository.findByProfileId(profileId);
    }

    @Override
    public void markNotificationAsSent(Long notificationId) {
        // Find the notification
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        // Mark as sent and save
        notification.setSent(true);
        notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getUnsentNotificationsByProfileId(Long profileId) {
        // Retrieve unsent notifications for the profile
        return notificationRepository.findByProfileIdAndSentFalse(profileId);
    }
}
