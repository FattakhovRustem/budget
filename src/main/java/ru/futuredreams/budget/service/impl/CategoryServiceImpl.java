package ru.futuredreams.budget.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.futuredreams.budget.dao.CategoryDao;
import ru.futuredreams.budget.model.Category;
import ru.futuredreams.budget.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao languageDao;

    @Override
    public Category getCategory(Integer languageId) { return languageDao.getCategory(languageId); }

    @Override
    @Transactional
    public Integer createCategory(Category Category) {
        return languageDao.createCategory(Category);
    }

    @Override
    @Transactional
    public void updateCategory(Category Category) {
        languageDao.updateCategory(Category);
    }

    @Override
    @Transactional
    public void deleteCategory(Integer languageId) {
        languageDao.deleteCategory(languageId);
    }

    @Override
    public List<Category> getCategories() {
        return languageDao.getCategories();
    }
}
