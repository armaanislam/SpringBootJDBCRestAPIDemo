package com.armaan.SpringDatasource.controller;

import com.armaan.SpringDatasource.entity.TestUser;
import com.armaan.SpringDatasource.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TestUserController {

    @Autowired
    private TestUserService testUserService;

    @GetMapping("/testuser/find/{id}")
    public TestUser findUser(@PathVariable("id") Long userId) {
        return testUserService.findUser(userId);
    }

    @GetMapping("/testuser/find")
    public Object findAllData() {
        List<TestUser> userList = testUserService.ReadAllUsers();
        return userList;
    }

    @PostMapping("/testuser")
    public String insertData(@Valid @RequestBody TestUser testUser) {
        String str = String.format("Data added successfully \n %s", testUserService.insertData(testUser));
        return str;
    }

    @PutMapping("/testuser/{id}")
    public String updateData(@PathVariable("id") Long userId, @Valid @RequestBody TestUser testUser) {
        String str = String.format("Data updated successfully \n %s", testUserService.updateData(testUser, userId));
        return str;
    }

    @DeleteMapping("/testuser/{id}")
    public String deleteData(@PathVariable("id") Long userId) {
        return testUserService.deleteData(userId);
    }

}
