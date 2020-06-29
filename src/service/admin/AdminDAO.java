package service.admin;

import model.Program;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO implements AdminService{
    private final String jdbcPassword = "Long12345^";
    private final String jdbcUsername = "long";
    private final String jdbcURL = "jdbc:mysql://localhost:3306/casestudy";
    private final String INSERT_PROGRAM = "{CALL insert_program(?)}";
    private final String SELECT_ALL_PROGRAM = "SELECT program_id, program_name FROM casestudy" +
            ".program";

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
    public void add(Program program) {
        System.out.println(INSERT_PROGRAM);
        try (
                Connection connection = getConnection(); PreparedStatement preparedStatement =
                connection.prepareStatement(INSERT_PROGRAM)
        ) {
            preparedStatement.setString(1,program.getProgramName());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public List<Program> findAllProgram() {
        List<Program> programs = new ArrayList<>();
        System.out.println(SELECT_ALL_PROGRAM);
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROGRAM);
        ) {

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("program_id");
                String programName = rs.getString("program_name");
                programs.add(new Program(id,programName));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return programs;
    }
}
