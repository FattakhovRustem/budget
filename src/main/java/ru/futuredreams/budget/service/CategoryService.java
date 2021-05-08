package ru.futuredreams.budget.service;

import ru.futuredreams.budget.model.Category;

import java.util.List;

public interface CategoryService {
    Category getCategory(Integer categoryId);

    Integer createCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Integer categoryId);

    List<Category> getCategories();
}
