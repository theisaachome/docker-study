package com.isaachome.restful.controller;


import com.isaachome.restful.model.Employee;
import com.isaachome.restful.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    // build create Employee REST API
    @PostMapping
    public ResponseEntity<Employee> createUser(@RequestBody Employee user){
        Employee savedUser = employeeService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // build get employee by id REST API
    // http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getUserById(@PathVariable("id") Long userId){
        Employee user = employeeService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Build Get All Employee REST API
    // http://localhost:8080/api/employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllUsers(){
        List<Employee> users = employeeService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build Update Employee REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<Employee> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody Employee user){
        user.setId(userId);
        Employee updatedUser = employeeService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        employeeService.deleteUser(userId);
        return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.OK);
    }
}
