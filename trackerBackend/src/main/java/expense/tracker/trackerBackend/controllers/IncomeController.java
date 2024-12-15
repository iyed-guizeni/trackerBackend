package expense.tracker.trackerBackend.controllers;

import expense.tracker.trackerBackend.entities.Income;
import expense.tracker.trackerBackend.service.interfaces.IIncome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/incomes")
public class IncomeController {

    @Autowired
    private IIncome incomeService;

    @PostMapping
    public ResponseEntity<Income> addIncome(@RequestBody Income income) {
        Income createdIncome = incomeService.addIncome(income);
        return ResponseEntity.ok(createdIncome);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id, @RequestBody Income income) {
        Income updatedIncome = incomeService.updateIncome(id, income);
        return ResponseEntity.ok(updatedIncome);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{profileId}/{startDate}/{endDate}")
    public ResponseEntity<List<Income>> getIncomesByProfileAndDateRange(
            @PathVariable Long profileId,
            @PathVariable String startDate,
            @PathVariable String endDate) {
        List<Income> incomes = incomeService.getIncomesByProfileAndDateRange(
                profileId, LocalDate.parse(startDate), LocalDate.parse(endDate));
        return ResponseEntity.ok(incomes);
    }
}
