package expense.tracker.trackerBackend.service.implement;

import expense.tracker.trackerBackend.dao.BudgetRepository;
import expense.tracker.trackerBackend.dao.ExpenseRepository;
import expense.tracker.trackerBackend.entities.Budget;
import expense.tracker.trackerBackend.service.interfaces.IBudget;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetImplement implements IBudget {

    @Autowired
    private BudgetRepository budgetRepository;
    
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Budget createBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    @Override
    public Budget getBudgetByProfileId(Long profileId) {
        return budgetRepository.findByProfileId(profileId);
    }

    @Override
    public Budget updateBudget(Long id, Budget budget) {
        Optional<Budget> existingBudget = budgetRepository.findById(id);
        
        if (existingBudget.isPresent()) {
            Budget updatedBudget = existingBudget.get();
            updatedBudget.setTotalBudget(budget.getTotalBudget());
            updatedBudget.setMonth(budget.getMonth());
            return budgetRepository.save(updatedBudget);
        } else {
            // Handle the case where the budget with the given ID doesn't exist
            // For example, you can throw an exception or return null
            throw new RuntimeException("Budget not found with id " + id);
        }
    }

    @Override
    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }
    
    @Override
    public boolean checkBudgetLimit(Long profileId, Double amount) {
        // Retrieve the budget for the given profileId
        Budget budget = budgetRepository.findByProfileId(profileId);

        if (budget == null) {
            throw new RuntimeException("Budget not found for profile id: " + profileId);
        }

        // Dynamically calculate current spending by summing expenses for the given profileId
        Double currentSpent = expenseRepository.sumExpensesByProfileId(profileId, LocalDate.now().getMonthValue());

        // Calculate the remaining budget
        Double remainingBudget = budget.getTotalBudget() - currentSpent;

        // Check if the amount exceeds the remaining budget
        return amount <= remainingBudget;
    }
}
