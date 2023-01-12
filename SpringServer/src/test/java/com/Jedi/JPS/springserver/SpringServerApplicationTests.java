package com.Jedi.JPS.springserver;

import com.Jedi.JPS.springserver.entities.employee.Employee;
import com.Jedi.JPS.springserver.entities.employee.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringServerApplicationTests {

	@Autowired
	private EmployeeDao employeeDao;

	@Test
	void addEmployees() {
		Employee employee = new Employee();
		employee.setName("Jay");
		employee.setBranch("ECE");
		employee.setLocation("GZB");

		employeeDao.save(employee);
	}
}
