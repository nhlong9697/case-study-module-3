package service.admin;

import model.ProgramClass;
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
    private final String UPDATE_PROGRAM = "{CALL update_program(?,?)}";
    private final String SELECT_ALL_CLASS = "SELECT class_id, class_name, program_id FROM " +
            "casestudy.class WHERE program_id = ?";
    private final String INSERT_CLASS = "{CALL insert_class(?,?)}";
    private final String SELECT_CLASS_BY_ID = "SELECT class_id, class_name, program_id FROM " +
            "casestudy.class WHERE class_id = ?";
    private final String DELETE_CLASS_BY_ID = "{CALL delete_class_by_id}";
    private final String UPDATE_CLASS = "{CALL update_class(?,?,?)}";
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
    public void addProgram(Program program) {
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
    public void removeProgram(int id) {
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

    @Override
    public void editProgram(Program program) {
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(UPDATE_PROGRAM);) {
            callableStatement.setString(1,program.getProgramName());
            callableStatement.setInt(2,program.getProgramId());
            System.out.println(UPDATE_PROGRAM);
            callableStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void addClass(ProgramClass newClass) {
        System.out.println(INSERT_CLASS);
        try (
                Connection connection = getConnection(); CallableStatement callableStatement =
                connection.prepareCall(INSERT_CLASS)
        ) {
            callableStatement.setString(1,newClass.getClassName());
            callableStatement.setInt(2,newClass.getProgramId());
            callableStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<ProgramClass> findAllClass(int programId) {
        List<ProgramClass> classList = new ArrayList<>();
        System.out.println(SELECT_ALL_CLASS);
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASS);
        ) {

            System.out.println(preparedStatement);
            preparedStatement.setInt(1,programId);

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("class_id");
                String className = rs.getString("class_name");
                int programIdOfClass = rs.getInt("program_id");
                classList.add(new ProgramClass(id,className,programIdOfClass));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return classList;
    }
}
