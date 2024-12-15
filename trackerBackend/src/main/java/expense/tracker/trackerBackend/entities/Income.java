package expense.tracker.trackerBackend.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String source;
    private Double amount;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    @JsonBackReference("profile-income")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference("category-income")
    private Category category;

    // Getter and Setter methods
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    // Methods to add, update, delete income and getIncomesByAccount() can be added
}
