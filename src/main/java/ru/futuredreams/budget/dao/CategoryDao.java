package ru.futuredreams.budget.dao;

import ru.futuredreams.budget.model.Category;

import java.util.List;

public interface CategoryDao {
    Category getCategory(Integer CategoryId);

    Integer createCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Integer CategoryId);

    List<Category> getCategories();
}
