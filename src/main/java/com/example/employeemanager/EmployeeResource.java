package com.example.employeemanager;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee") //default are base URL
public class EmployeeResource {

    @Autowired
    private final EmployeeService employeeService;  //use the service

    public EmployeeResource(EmployeeService employeeService){  //inject through constructor to autowire
        this.employeeService = employeeService;
    }
    @GetMapping("/all")     //retrive info about employee
    //generic method
    public ResponseEntity<List <Employee>> getAllEmployee(){
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK); //200 response
    }
    @GetMapping("/find/{id}") //pathvariable reads the id
    public ResponseEntity<Employee> getEmployeeId(@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK); //200 response
    }

    @PostMapping("/add") //map to empolyee which is at class level. Post request to make a change in actual backend
    //expecting employee object in json format
    //RequestBody to convert the object as Employee object
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED); //created new pieece of info in the app
    }

    @PutMapping("/update")           //employee already exists, we are only updating the info
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    //? doesn't return anything
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
