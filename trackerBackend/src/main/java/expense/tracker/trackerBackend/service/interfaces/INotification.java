package expense.tracker.trackerBackend.service.interfaces;

import expense.tracker.trackerBackend.entities.Notification;

import java.util.List;

public interface INotification{

    // Create a new notification for a profile
    void createNotification(String message, Long profileId);

    // Fetch notifications for a specific profile
    List<Notification> getNotificationsByProfileId(Long profileId);

    // Mark notifications as sent
    void markNotificationAsSent(Long notificationId);

    // Fetch unsent notifications for a profile
    List<Notification> getUnsentNotificationsByProfileId(Long profileId);
}
