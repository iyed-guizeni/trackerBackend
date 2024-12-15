package expense.tracker.trackerBackend.dao;

import expense.tracker.trackerBackend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Custom query to find a category by name
    Category findByName(String name);
}
