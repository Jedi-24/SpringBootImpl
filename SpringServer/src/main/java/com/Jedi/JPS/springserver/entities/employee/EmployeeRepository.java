package com.Jedi.JPS.springserver.entities.employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    // and we GET all the functionalities of CrudRepository interface.
}
