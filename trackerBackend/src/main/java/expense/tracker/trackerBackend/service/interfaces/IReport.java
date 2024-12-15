package expense.tracker.trackerBackend.service.interfaces;

import expense.tracker.trackerBackend.entities.Expense;
import expense.tracker.trackerBackend.entities.Income;

import java.time.LocalDate;
import java.util.List;

public interface IReport {
    List<Expense> getExpensesByDate(Long profileId, LocalDate startDate, LocalDate endDate);
    List<Income> getIncomesByDate(Long profileId, LocalDate startDate, LocalDate endDate);
    //String generateSummary(Long profileId, String category);
}
