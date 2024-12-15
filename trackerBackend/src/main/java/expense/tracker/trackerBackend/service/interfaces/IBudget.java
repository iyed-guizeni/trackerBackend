package expense.tracker.trackerBackend.service.interfaces;

import expense.tracker.trackerBackend.entities.Budget;

public interface IBudget{
    Budget createBudget(Budget budget);
    Budget getBudgetByProfileId(Long profileId);
    Budget updateBudget(Long id,Budget budget);
    void deleteBudget(Long id);
    boolean checkBudgetLimit(Long profileId, Double amount);
}
