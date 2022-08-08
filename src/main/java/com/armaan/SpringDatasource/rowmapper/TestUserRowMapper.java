package com.armaan.SpringDatasource.rowmapper;

import com.armaan.SpringDatasource.entity.TestUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestUserRowMapper implements RowMapper<TestUser> {

    @Override
    public TestUser mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        TestUser testUser = new TestUser();

        testUser.setId(resultSet.getLong("id"));
        testUser.setName(resultSet.getString("name"));
        testUser.setContact_no(resultSet.getString("contact_no"));
        testUser.setAddress(resultSet.getString("address"));
        testUser.setEmail(resultSet.getString("email"));
        testUser.setCreated_at(resultSet.getDate("created_at"));
        testUser.setCreated_by(resultSet.getLong("created_by"));
        testUser.setUpdated_at(resultSet.getDate("updated_at"));
        testUser.setUpdated_by(resultSet.getLong("updated_by"));
        testUser.setObj_status(resultSet.getBoolean("obj_status"));

        return testUser;
    }

}

