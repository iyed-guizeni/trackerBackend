package expense.tracker.trackerBackend.service.interfaces;

import expense.tracker.trackerBackend.entities.Income;

import java.time.LocalDate;
import java.util.List;

public interface IIncome {
    Income addIncome(Income income);
    Income updateIncome(Long id, Income income);
    void deleteIncome(Long id);
    List<Income> getIncomesByProfileId(Long profileId);
    List<Income> getIncomesByCategoryId(Long categoryId);
    
    List<Income> getIncomesByProfileAndDateRange(Long profileId, LocalDate startDate, LocalDate endDate);

}
