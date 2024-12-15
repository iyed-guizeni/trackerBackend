package expense.tracker.trackerBackend.service.interfaces;

import expense.tracker.trackerBackend.entities.Expense;

import java.time.LocalDate;
import java.util.List;

public interface IExpense {
    Expense addExpense(Expense expense);
    Expense updateExpense(Long id ,Expense expense);
    void deleteExpense(Long id);
    List<Expense> getExpensesByProfileId(Long profileId);
    List<Expense> getExpensesByCategoryId(Long categoryId);
    List<Expense> findByProfileIdAndDateBetween(Long profileId, LocalDate startDate, LocalDate endDate);

}
