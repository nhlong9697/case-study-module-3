package service;

import model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentDAO implements StudentService{
    private String jdbcUsername = "long";
    private String jdbcPassword = "Long12345^";
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy";
    public StudentDAO() {
    }
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public void add(Student student) {
        String addQuery = "{CALL insert_student(?,?,?,?)}";

    }
}
