package com.isaachome.restful.service;

import com.isaachome.restful.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createUser(Employee user);

    Employee getUserById(Long userId);

    List<Employee> getAllUsers();

    Employee updateUser(Employee user);

    void deleteUser(Long userId);
}
