package ru.futuredreams.budget.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.futuredreams.budget.model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet resultSet, int i) throws SQLException {
        Category category = new Category();
        category.setId(resultSet.getInt("ID"));
        category.setName(resultSet.getString("NAME"));
        return category;
    }
}
