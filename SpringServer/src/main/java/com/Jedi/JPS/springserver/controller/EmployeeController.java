package com.Jedi.JPS.springserver.controller;

import com.Jedi.JPS.springserver.entities.employee.Employee;
import com.Jedi.JPS.springserver.entities.employee.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee/getAll")
    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }

    @PostMapping("/employee/save")
    public void saveEmployee(@RequestBody Employee employee){
        employeeDao.save(employee);
    }
}
