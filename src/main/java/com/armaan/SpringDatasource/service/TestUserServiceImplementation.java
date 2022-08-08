package com.armaan.SpringDatasource.service;

import com.armaan.SpringDatasource.entity.TestUser;
import com.armaan.SpringDatasource.repository.TestUserRepository;
import com.armaan.SpringDatasource.rowmapper.TestUserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestUserServiceImplementation implements TestUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TestUserRepository testUserRepository;

    @Override
    public TestUser insertData(TestUser testUser) {
        String sql = "INSERT INTO test_user(name, contact_no, address, email, created_at, created_by, updated_at, updated_by, obj_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] arg = {testUser.getName(), testUser.getContact_no(), testUser.getAddress(), testUser.getEmail(), testUser.getCreated_at(), testUser.getCreated_by(), testUser.getUpdated_at(), testUser.getUpdated_by(), testUser.getObj_status()};
        jdbcTemplate.update(sql, arg);
        return testUser;
    }

    @Override
    public TestUser findUser(Long userId) {
        String sql = "SELECT * FROM test_user WHERE id = ?";
        TestUser newtestUser = jdbcTemplate.queryForObject(sql, new TestUserRowMapper(), userId);
        return newtestUser;
    }

    @Override
    public List<TestUser> ReadAllUsers() {
        String sql = "SELECT * FROM test_user";
        List<TestUser> userList = jdbcTemplate.query(sql, new TestUserRowMapper());
        return userList;
    }

    @Override
    public TestUser updateData(TestUser testUser, Long userId) {
        String sql = "UPDATE test_user SET name = ?, contact_no = ?, address = ?, email = ?, created_by = ?, updated_by = ?, obj_status = ? WHERE id = ?";
        Object[] arg = {testUser.getName(), testUser.getContact_no(), testUser.getAddress(), testUser.getEmail(), testUser.getCreated_by(), testUser.getUpdated_by(), testUser.getObj_status(), userId};
        jdbcTemplate.update(sql, arg);
        return testUser;
    }

    @Override
    public String deleteData(Long userId) {
        String sql = "DELETE FROM test_user WHERE id = ?";
        int row = jdbcTemplate.update(sql, userId);
        if(row != 0) {
            return "Row deleted successfully";
        } else {
            return "Data not found";
        }
    }

}
