package ru.futuredreams.budget.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.futuredreams.budget.dao.CategoryDao;
import ru.futuredreams.budget.model.Category;
import ru.futuredreams.budget.model.mapper.CategoryMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    private final static String SQL_SELECT_LANGUAGE = "SELECT ID, NAME FROM budget.category " +
            "WHERE id = :id";

    private final static String SQL_CREATE_LANGUAGE = "INSERT INTO " +
            "budget.category(name) VALUES (:name)";

    private final static String SQL_UPDATE_LANGUAGE = "UPDATE budget.category " +
            "SET name = :name WHERE id = :id";

    private final static String SQL_DELETE_LANGUAGE = "DELETE FROM budget.category WHERE id = :id";

    private final static String SQL_SELECT_ALL_LANGUAGES = "SELECT ID, NAME FROM budget.category ORDER BY id ASC";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Category getCategory(Integer categoryId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", categoryId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_LANGUAGE, paramMap, new CategoryMapper());
    }

    @Override
    @Transactional
    public Integer createCategory(Category category) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", category.getName());
        namedParameterJdbcTemplate.update(SQL_CREATE_LANGUAGE, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", category.getId());
        params.put("name", category.getName());
        namedParameterJdbcTemplate.update(SQL_UPDATE_LANGUAGE, params);
    }

    @Override
    @Transactional
    public void deleteCategory(Integer categoryId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", categoryId);
        namedParameterJdbcTemplate.update(SQL_DELETE_LANGUAGE, params);
    }

    @Override
    public List<Category> getCategories() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_LANGUAGES, new CategoryMapper());
    }
}

