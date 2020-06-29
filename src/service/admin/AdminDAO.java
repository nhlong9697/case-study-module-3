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
    private final String SELECT_PROGRAM_BY_ID = "SELECT program_id, program_name FROM casestudy" +
            ".program WHERE program_id = ?";
    private final String DELETE_PROGRAM_BY_ID = "{CALL delete_program_by_id(?)}";
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
                Connection connection = getConnection(); CallableStatement callableStatement =
                connection.prepareCall(INSERT_PROGRAM)
        ) {
            callableStatement.setString(1,program.getProgramName());
            callableStatement.executeUpdate();
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

    @Override
    public Program findProgramById(int id) {
       Program program = null;
       try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROGRAM_BY_ID);
       ) {

            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                String programName = rs.getString("program_name");
                int programId = rs.getInt("program_id");
                program = new Program(programId,programName);
            }

       } catch (SQLException exception) {
            exception.printStackTrace();
       }
       return program;
    }

    @Override
    public void remove(int id) {
        try (Connection connection = getConnection();
             CallableStatement callableStatement =
                     connection.prepareCall(DELETE_PROGRAM_BY_ID);
        ) {
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
