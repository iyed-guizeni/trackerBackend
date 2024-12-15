package expense.tracker.trackerBackend.controllers;

import expense.tracker.trackerBackend.dao.ProfileRepository;
import expense.tracker.trackerBackend.entities.Budget;
import expense.tracker.trackerBackend.entities.Profile;
import expense.tracker.trackerBackend.service.interfaces.IBudget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    @Autowired
    private IBudget budgetService;

    
    @Autowired
    private ProfileRepository profileRepository;
    
    @PostMapping
    public ResponseEntity<Budget> createBudget(@RequestBody Budget budget) {
        if (budget.getProfile() != null && budget.getProfile().getId() != null) {
            // Fetch the Profile entity based on profile_id
            Profile profile = profileRepository.findById(budget.getProfile().getId())
                    .orElseThrow(() -> new RuntimeException("Profile not found with id: " + budget.getProfile().getId()));

            // Associate the budget with the profile
            budget.setProfile(profile);

            // Save the budget to the database
            Budget createdBudget = budgetService.createBudget(budget);

            // Now update the profile's budget field (ensure that the profile is saved as well)
            profile.setBudget(createdBudget);
            profileRepository.save(profile); // Save the profile with the updated budget

            return ResponseEntity.ok(createdBudget);
        } else {
            throw new RuntimeException("Profile is required to create a budget");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Budget> updateBudget(@PathVariable Long id, @RequestBody Budget budget) {
        Budget updatedBudget = budgetService.updateBudget(id, budget);
        return ResponseEntity.ok(updatedBudget);
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<Budget> getBudgetByProfile(@PathVariable Long profileId) {
        Budget budget = budgetService.getBudgetByProfileId(profileId);
        return ResponseEntity.ok(budget);
    }

   

    @GetMapping("/check-limit/{profileId}/{amount}")
    public ResponseEntity<Boolean> checkBudgetLimit(@PathVariable Long profileId, @PathVariable Double amount) {
        boolean isUnderLimit = budgetService.checkBudgetLimit(profileId, amount);
        return ResponseEntity.ok(isUnderLimit);
    }
}
