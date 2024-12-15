package expense.tracker.trackerBackend.service.implement;

import expense.tracker.trackerBackend.dao.CategoryRepository;
import expense.tracker.trackerBackend.entities.Category;
import expense.tracker.trackerBackend.service.interfaces.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImplement implements ICategory {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        // Check if the category with the given ID exists
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + id));

        // Update the category details
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());

        // Save and return the updated category
        return categoryRepository.save(existingCategory);
    }


    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
