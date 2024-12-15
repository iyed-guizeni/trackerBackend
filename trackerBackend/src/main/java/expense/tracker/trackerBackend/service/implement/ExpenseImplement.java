package expense.tracker.trackerBackend.service.implement;

import expense.tracker.trackerBackend.dao.ExpenseRepository;
import expense.tracker.trackerBackend.entities.Expense;
import expense.tracker.trackerBackend.service.interfaces.IExpense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseImplement implements IExpense {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(Long id, Expense expense) {
        // Fetch the existing expense by ID
        Expense existingExpense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense with ID " + id + " not found"));

        // Update allowed fields
        existingExpense.setTitle(expense.getTitle());
        existingExpense.setAmount(expense.getAmount());
        existingExpense.setDate(expense.getDate());
        existingExpense.setCategory(expense.getCategory());

        // Save and return the updated expense
        return expenseRepository.save(existingExpense);
    }


    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public List<Expense> getExpensesByProfileId(Long profileId) {
        return expenseRepository.findByProfileId(profileId);
    }

    @Override
    public List<Expense> getExpensesByCategoryId(Long categoryId) {
        return expenseRepository.findByCategoryId(categoryId);
    }
    
    @Override
    public List<Expense> findByProfileIdAndDateBetween(Long profileId, LocalDate startDate, LocalDate endDate) {
        return expenseRepository.findByProfileIdAndDateBetween(profileId, startDate, endDate);
    }
}
