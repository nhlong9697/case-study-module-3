package service.student;

import model.Student;

import java.sql.CallableStatement;
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
    public boolean add(Student student) {
        String addQuery = "{CALL insert_student(?,?,?,?,?,?)}";
        boolean isAdded = false;
        try (Connection connection = getConnection();
             CallableStatement callableStatement =
                connection.prepareCall(addQuery)
        ) {
            callableStatement.setString(1, student.getUsername());
            callableStatement.setString(2,student.getPassword());
            callableStatement.setString(3,student.getFirstName());
            callableStatement.setString(4,student.getLastName());
            callableStatement.setString(5,student.getEmail());
            callableStatement.setString(6,student.getLastName());
            isAdded = callableStatement.executeUpdate() == 1;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return isAdded;

    }
}
