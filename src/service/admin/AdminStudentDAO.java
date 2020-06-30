package service.admin;

import model.Program;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminStudentDAO implements AdminStudentService{
    private final String jdbcPassword = "Long12345^";
    private final String jdbcUsername = "long";
    private final String jdbcURL = "jdbc:mysql://localhost:3306/casestudy";
    private final String INSERT_USER = "{CALL insert_student(?,?,?,?,?,?)}";
    private final String SELECT_ALL_STUDENT_FROM_A_CLASS = "SELECT * FROM casestudy.student WHERE" +
            " class_id = ?";
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("connected");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public void addStudent(Student newStudent) {
        System.out.println(INSERT_USER);
        try (
                Connection connection = getConnection(); CallableStatement callableStatement =
                connection.prepareCall(INSERT_USER)
        ) {
            callableStatement.setString(1,newStudent.getUsername());
            callableStatement.setString(2,newStudent.getPassword());
            callableStatement.setString(3,newStudent.getFirstName());
            callableStatement.setString(4,newStudent.getLastName());
            callableStatement.setInt(5,newStudent.getClassId());
            callableStatement.setString(6,newStudent.getEmail());
            callableStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Student> findAllStudentOfAClass(int classId) {
        List<Student> studentList = new ArrayList<>();
        System.out.println(SELECT_ALL_STUDENT_FROM_A_CLASS);
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT_FROM_A_CLASS);
        ) {

            System.out.println(preparedStatement);
            preparedStatement.setInt(1,classId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("student_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                studentList.add(new Student(id,username,password,firstName,lastName,email,classId));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return studentList;
    }

    @Override
    public Student findStudentById(int id) {
        return null;
    }

    @Override
    public void removeStudentById(int id) {

    }
}
