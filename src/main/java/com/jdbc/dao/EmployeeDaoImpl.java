package com.jdbc.dao;

import com.jdbc.model.Employee;
import com.jdbc.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{


    @Override
    public List<Employee> findAll() {
        Connection con = DBConnection.getConnection();
        if(con == null) {
            return null;
        }
        List<Employee> employess = new LinkedList<>();

        String query = "SELECT * FROM employee";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                Employee employee = new Employee(resultSet.getByte("id"),
//                                                 resultSet.getString("name"),
//                                                 resultSet.getBoolean("gender"),
//                                                 resultSet.getDate("birth_data"),
//                                                 resultSet.getDouble("salary"));

                Employee employee = Employee.builder()
                        .id(resultSet.getByte("id"))
                        .name(resultSet.getString("name"))
                        .gender(resultSet.getBoolean("gender"))
                        .birth_date(resultSet.getDate("birth_data"))
                        .salary(resultSet.getDouble("salary"))
                        .build();
                employess.add(employee);
            }
        } catch (SQLException soe) {
            soe.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException soe) {
                soe.printStackTrace();
            }
        }
        return employess;
    }

    @Override
    public Employee findById(int id) {
        Connection connection = DBConnection.getConnection();
        if(connection == null) {
            return null;
        }

        String query = "SELECT * FROM employee WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return Employee.builder()
                        .id(resultSet.getByte("id"))
                        .name(resultSet.getString("name"))
                        .gender(resultSet.getBoolean("gender"))
                        .birth_date(resultSet.getDate("birth_data"))
                        .salary(resultSet.getDouble("salary"))
                        .build();
            }
        } catch (SQLException sep) {
            sep.printStackTrace();
        } finally {
            try {
                connection.close();
            }catch (SQLException sep) {
                sep.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void save(Employee employee) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return;
        }

        if(employee.getId() > 0) {
            //update
            String query = "UPDATE employee SET name=?, gender=?, birth_data=?, salary=? WHERE id=?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setBoolean(2, employee.isGender());
                preparedStatement.setDate(3, Utils.getSqlDate(employee.getBirthDate()));
                preparedStatement.setDouble(4, employee.getSalary());
                preparedStatement.setInt(5, employee.getId());

                preparedStatement.executeUpdate();

            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException ser) {
                    ser.printStackTrace();
                }
            }
        }else {
            //create
            String query = "INSERT INTO employee (name, gender, birth_data, salary) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setBoolean(2, employee.isGender());
                preparedStatement.setDate(3, Utils.getSqlDate(employee.getBirthDate()));
                preparedStatement.setDouble(4, employee.getSalary());

                preparedStatement.executeUpdate();

            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException ser) {
                    ser.printStackTrace();
                }
            }
        }

    }

    @Override
    public void deleteById(int id) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return;
        }

        String query = "DELETE FROM employee WHERE id=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException sew) {
            sew.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException sew) {
                sew.printStackTrace();
            }
        }
        return;
    }
}
