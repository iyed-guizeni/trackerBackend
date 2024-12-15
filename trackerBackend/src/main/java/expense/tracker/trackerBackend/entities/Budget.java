package expense.tracker.trackerBackend.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double totalBudget;
    //private Double currentSpent;
    private LocalDate month;

    @OneToOne
    @JoinColumn(name = "profile_id")
    @JsonBackReference("profile-budget")
    private Profile profile;

    // Getter and Setter methods
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getTotalBudget() { return totalBudget; }
    public void setTotalBudget(Double totalBudget) { this.totalBudget = totalBudget; }

    //public Double getCurrentSpent() { return currentSpent; }
    //public void setCurrentSpent(Double currentSpent) { this.currentSpent = currentSpent; }

    public LocalDate getMonth() { return month; }
    public void setMonth(LocalDate month) { this.month = month; }

    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }
    
    //public boolean checkLimit(Double amount) {
        //return (currentSpent + amount) <= totalBudget;
    //}

    // Additional methods like setBudget(), updateBudget(), checkLimit() can be added
}
