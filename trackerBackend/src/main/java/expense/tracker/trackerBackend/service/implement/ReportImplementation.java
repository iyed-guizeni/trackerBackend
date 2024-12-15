package expense.tracker.trackerBackend.service.implement;

import expense.tracker.trackerBackend.dao.ExpenseRepository;
import expense.tracker.trackerBackend.dao.IncomeRepository;
import expense.tracker.trackerBackend.entities.Expense;
import expense.tracker.trackerBackend.entities.Income;
import expense.tracker.trackerBackend.service.interfaces.IReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportImplementation implements IReport {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private IncomeRepository incomeRepository;

    @Override
    public List<Expense> getExpensesByDate(Long profileId, LocalDate startDate, LocalDate endDate) {
        return expenseRepository.findByProfileIdAndDateBetween(profileId, startDate, endDate);
    }

    @Override
    public List<Income> getIncomesByDate(Long profileId, LocalDate startDate, LocalDate endDate) {
        return incomeRepository.findByProfileIdAndDateBetween(profileId, startDate, endDate);
    }

    //@Override
    //public String generateSummary(Long profileId, String category) {
        // Custom logic for generating summary
       // return "Summary for profileId: " + profileId + " and category: " + category;
    //}
}
