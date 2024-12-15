package expense.tracker.trackerBackend.controllers;

import expense.tracker.trackerBackend.entities.Expense;
import expense.tracker.trackerBackend.entities.Income;
import expense.tracker.trackerBackend.service.interfaces.IReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private IReport reportService;

    // Endpoint to get expenses by date range for a specific profile
    @GetMapping("/expenses")
    public ResponseEntity<List<Expense>> getExpensesByDate(
            @RequestParam Long profileId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        List<Expense> expenses = reportService.getExpensesByDate(profileId, startDate, endDate);
        return ResponseEntity.ok(expenses);
    }

    // Endpoint to get incomes by date range for a specific profile
    @GetMapping("/incomes")
    public ResponseEntity<List<Income>> getIncomesByDate(
            @RequestParam Long profileId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        List<Income> incomes = reportService.getIncomesByDate(profileId, startDate, endDate);
        return ResponseEntity.ok(incomes);
    }

    
}
