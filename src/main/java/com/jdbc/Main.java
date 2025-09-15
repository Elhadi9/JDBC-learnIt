package com.jdbc;

import com.jdbc.dao.*;
import com.jdbc.dao.EmployeeDao;
import com.jdbc.model.Employee;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoImpl();

        Employee employee = new Employee(
                0,
                "Hadi",
                true,
                Date.valueOf(LocalDate.now()),
                252525d
        );

        Employee employee1 = Employee.builder()
                .name("Mohamed")
                .gender(true)
                .birth_date(Date.valueOf(LocalDate.now()))
                .salary(0.0)
                .build();

        employeeDao.save(employee);
//        employeeDao.findAll().forEach(System.out::println);

        Employee emp =  employeeDao.findById(5);
        System.out.println(emp);

        employeeDao.deleteById(5);

        Employee emp1 =  employeeDao.findById(6);
        System.out.println(emp1);

    }
}