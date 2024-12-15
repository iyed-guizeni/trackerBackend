package expense.tracker.trackerBackend.dao;

import expense.tracker.trackerBackend.entities.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    // Custom query to find a budget by profile ID
    Budget findByProfileId(Long profileId);
}
