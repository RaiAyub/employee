package com.example.employeemanager.Repo;

import com.example.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//tell what class -> employee and what primary keey -> Long
    public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById (Long id);
    Optional <Employee> findEmployeeById(Long id); //query method -> spring understands by naming convention
}

