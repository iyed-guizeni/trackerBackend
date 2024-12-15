package expense.tracker.trackerBackend.controllers;

import expense.tracker.trackerBackend.entities.Notification;
import expense.tracker.trackerBackend.service.interfaces.INotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private INotification notificationService;

    // Create a new notification for a profile
    @PostMapping("/create")
    public void createNotification(@RequestParam String message, @RequestParam Long profileId) {
        notificationService.createNotification(message, profileId);
    }

    // Get all notifications for a specific profile
    @GetMapping("/profile/{profileId}")
    public List<Notification> getNotifications(@PathVariable Long profileId) {
        return notificationService.getNotificationsByProfileId(profileId);
    }

    // Get unsent notifications for a specific profile
    @GetMapping("/profile/{profileId}/unsent")
    public List<Notification> getUnsentNotifications(@PathVariable Long profileId) {
        return notificationService.getUnsentNotificationsByProfileId(profileId);
    }

    // Mark a notification as sent
    @PutMapping("/markAsSent/{notificationId}")
    public void markNotificationAsSent(@PathVariable Long notificationId) {
        notificationService.markNotificationAsSent(notificationId);
    }
}
