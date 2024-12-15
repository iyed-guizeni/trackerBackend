package expense.tracker.trackerBackend.controllers;

import expense.tracker.trackerBackend.entities.Expense;
import expense.tracker.trackerBackend.service.interfaces.IExpense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private IExpense expenseService;

    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        Expense createdExpense = expenseService.addExpense(expense);
        return ResponseEntity.ok(createdExpense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        Expense updatedExpense = expenseService.updateExpense(id, expense);
        return ResponseEntity.ok(updatedExpense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{profileId}/{startDate}/{endDate}")
    public ResponseEntity<List<Expense>> getExpensesByProfileAndDateRange(
            @PathVariable Long profileId,
            @PathVariable String startDate,
            @PathVariable String endDate) {
        List<Expense> expenses = expenseService.findByProfileIdAndDateBetween(
                profileId, LocalDate.parse(startDate), LocalDate.parse(endDate));
        return ResponseEntity.ok(expenses);
    }
}
