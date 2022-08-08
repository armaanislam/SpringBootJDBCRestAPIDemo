package com.armaan.SpringDatasource.service;

import com.armaan.SpringDatasource.entity.TestUser;

import java.util.List;

public interface TestUserService {

    TestUser insertData(TestUser testUser);

    TestUser findUser(Long userId);

    List<TestUser> ReadAllUsers();

    TestUser updateData(TestUser testUser, Long userId);

    String deleteData(Long userId);

}
