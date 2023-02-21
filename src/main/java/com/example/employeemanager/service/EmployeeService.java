package com.example.employeemanager.service;

import com.example.employeemanager.Repo.EmployeeRepo;
import com.example.employeemanager.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employeemanager.exception.UserNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    static Logger log = LogManager.getLogger(EmployeeService.class);
    final private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService (EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
         employee.setEmployeeCode(UUID.randomUUID().toString());
         log.info("Employee added {}", Mapper.mapToJsonString(employee));
         return employeeRepo.save(employee);
    }

    public List <Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        log.info("Employee updated {} ", Mapper.mapToJsonString(employee));
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User id " + id + " not Found " + "\n"));
    }

}
