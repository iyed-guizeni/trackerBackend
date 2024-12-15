package expense.tracker.trackerBackend.service.interfaces;

import expense.tracker.trackerBackend.entities.Category;

import java.util.List;

public interface ICategory {
    Category addCategory(Category category);
    Category updateCategory(Long id ,Category category);
    void deleteCategory(Long id);
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
}
