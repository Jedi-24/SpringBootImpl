package com.Jedi.JPS.springserver.entities.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // as we will be using this class from other places THROUGH auto-wiring, now what is auto wiring ?
public class EmployeeDao { // in-charge for doing all the DB operations
    // 1) GET object of EmployeeRepository: we use something called as dependency injection mechanism, auto-injection.
    @Autowired
    private EmployeeRepository repository; // no need to write repo = new EmployeeRepository(){// methods to be implemented..}

    public void save(Employee employee){
        repository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(employees::add);
        return employees;
    }

    public void delete(Employee employee){
        repository.delete(employee);
    }
}
