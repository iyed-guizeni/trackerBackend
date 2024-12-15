package expense.tracker.trackerBackend.service.implement;

import expense.tracker.trackerBackend.dao.IncomeRepository;
import expense.tracker.trackerBackend.entities.Income;
import expense.tracker.trackerBackend.service.interfaces.IIncome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IncomeImplement implements IIncome {

    @Autowired
    private IncomeRepository incomeRepository;

    @Override
    public Income addIncome(Income income) {
        return incomeRepository.save(income);
    }

    @Override
    public Income updateIncome(Long id, Income income) {
        // Fetch the existing Income by ID
        Income existingIncome = incomeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Income not found with id: " + id));
        
        // Update the fields of the existing Income
        existingIncome.setSource(income.getSource());
        existingIncome.setAmount(income.getAmount());
        existingIncome.setDate(income.getDate());
        existingIncome.setCategory(income.getCategory());

        // Save and return the updated Income
        return incomeRepository.save(existingIncome);
    }


    @Override
    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }

    @Override
    public List<Income> getIncomesByProfileId(Long profileId) {
        return incomeRepository.findByProfileId(profileId);
    }

    @Override
    public List<Income> getIncomesByCategoryId(Long categoryId) {
        return incomeRepository.findByCategoryId(categoryId);
    }
    
    @Override
    public List<Income> getIncomesByProfileAndDateRange(Long profileId, LocalDate startDate, LocalDate endDate) {
        return incomeRepository.findByProfileIdAndDateBetween(profileId, startDate, endDate);
    }
}
