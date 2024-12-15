package expense.tracker.trackerBackend.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    
    private boolean sent;

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    @JsonBackReference("profile-notification")
    private Profile profile;
    
    public Notification() {
    }

    public Notification(String message, Profile profile) {
        this.message = message;
        this.profile = profile;
        this.sent = false;  // Notifications are initially not sent
        this.timestamp = LocalDateTime.now();  // Set timestamp on creation
    }

    // Getter and Setter methods
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean isSent() { return sent; }
    public void setSent(boolean sent) { this.sent = sent; }

    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }

    // Methods like createNotification and sendNotification
}
