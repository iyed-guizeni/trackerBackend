package expense.tracker.trackerBackend.dao;

import expense.tracker.trackerBackend.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Custom query to find expenses by profile ID
    List<Expense> findByProfileId(Long profileId);

    // Custom query to find expenses by category ID
    List<Expense> findByCategoryId(Long categoryId);
    
    //for report
    List<Expense> findByProfileIdAndDateBetween(Long profileId, LocalDate startDate, LocalDate endDate);
     
    
    //sum expense to know the rest of budget
    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.profile.id = :profileId AND MONTH(e.date) = :month")
    Double sumExpensesByProfileId(Long profileId, int month);
}
