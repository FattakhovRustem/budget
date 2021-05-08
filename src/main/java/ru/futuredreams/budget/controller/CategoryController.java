package ru.futuredreams.budget.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.futuredreams.budget.model.Category;
import ru.futuredreams.budget.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping(value = "/categories", produces = "application/json;charset=UTF-8")
public class CategoryController {
    private static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Category>> getCategories() {
        logger.debug("get categories");
        List<Category> categorys = categoryService.getCategories();
        return new ResponseEntity<>(categorys, HttpStatus.OK);
    }

    @GetMapping(value = "/{categoryId}")
    @ResponseBody
    public ResponseEntity<Category> getCategory(@PathVariable Integer categoryId) {
        logger.debug("get category - {}", categoryId);
        Category category = categoryService.getCategory(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Category> createcategory(@RequestBody Category category) {
        logger.debug("create category - {}", category);
        Integer categoryId = categoryService.createCategory(category);
        category = categoryService.getCategory(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping(value = "/{categoryId}")
    @ResponseBody
    public ResponseEntity<Category> updatecategory(@PathVariable Integer categoryId, @RequestBody Category category) {
        logger.debug("update category - {}", category);
        category.setId(categoryId);
        categoryService.updateCategory(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{categoryId}")
    public ResponseEntity<Integer> deletecategory(@PathVariable Integer categoryId) {
        logger.debug("delete category - {}", categoryId);
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(categoryId, HttpStatus.OK);
    }
}
