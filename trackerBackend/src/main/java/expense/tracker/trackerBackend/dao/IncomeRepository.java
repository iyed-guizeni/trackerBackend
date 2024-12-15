package expense.tracker.trackerBackend.dao;

import expense.tracker.trackerBackend.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
    // Custom query to find incomes by profile ID
    List<Income> findByProfileId(Long profileId);

    // Custom query to find incomes by category ID
    List<Income> findByCategoryId(Long categoryId);
    
    //for report
    List<Income> findByProfileIdAndDateBetween(Long profileId, LocalDate startDate, LocalDate endDate);

}
