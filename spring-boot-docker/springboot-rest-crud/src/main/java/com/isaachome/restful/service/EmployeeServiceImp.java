package com.isaachome.restful.service;

import com.isaachome.restful.model.Employee;
import com.isaachome.restful.repos.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements  EmployeeService{
    private  final EmployeeRepo employeeRepo;

    public EmployeeServiceImp(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee createUser(Employee user) {
        return employeeRepo.save(user);
    }

    @Override
    public Employee getUserById(Long userId) {
        return employeeRepo.findById(userId).orElseThrow(()->new RuntimeException("There is No Employee with " + userId));
    }

    @Override
    public List<Employee> getAllUsers() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee updateUser(Employee user) {
        Employee existingUser = employeeRepo.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        Employee updatedUser = employeeRepo.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
         employeeRepo.deleteById(userId);
    }
}
