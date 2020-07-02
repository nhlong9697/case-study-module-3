package controller.admin;

import model.Program;
import model.ProgramClass;
import model.Student;
import service.admin.AdminDAO;
import service.admin.AdminService;
import service.admin.AdminStudentDAO;
import service.admin.AdminStudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ClassManagementServlet", urlPatterns = {"/admin/program/*","/admin/program" +
        "/*/class"})
public class ClassManagementServlet extends HttpServlet {
    private final AdminService adminService = new AdminDAO();
    private final AdminStudentService adminStudentService = new AdminStudentDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session.getAttribute("admin") == null) {
            request.setAttribute("not-login", "Please login as admin");
            response.sendRedirect("/admin");
        } else {

            String action = request.getParameter("action");
            String pathInfo[] = request.getPathInfo().split("/");
            System.out.println(Arrays.toString(pathInfo));
            String id = pathInfo[1];
            int programId = Integer.parseInt(id);
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "addClass":
                    addClass(request, response, programId);
                    break;
                case "deleteClass":
                    deleteClass(request, response, programId);
                    break;
                case "editClass":
                    editClass(request, response, programId);
                    break;
                default:
                    break;
            }
        }

    }



    private void editClass(HttpServletRequest request, HttpServletResponse response, int programId) {
    }

    private void deleteClass(HttpServletRequest request, HttpServletResponse response, int programId) {
        int id = Integer.parseInt(request.getParameter("id"));
        ProgramClass programClass = this.adminService.findClassById(id);
        if (programClass == null) {
            try {
                request.getRequestDispatcher("/error-404.jsp").forward(request,response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            this.adminService.removeClass(id);
            try {
                response.sendRedirect("/admin/program/" + programId);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    private void addClass(HttpServletRequest request, HttpServletResponse response, int programId) {

        String className = request.getParameter("className");
        ProgramClass newClass = new ProgramClass(className,programId);
        this.adminService.addClass(newClass);
        request.setAttribute("programId",programId);
        request.setAttribute("message","New program is added");
        try {
            request.getRequestDispatcher("/admin/class_management/addClass.jsp").forward(request,
                    response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session.getAttribute("admin") == null) {
            request.setAttribute("not-login","Please login as admin");
            response.sendRedirect("/admin");
        } else {
            String pathInfo[] = request.getPathInfo().split("/");
            System.out.println(Arrays.toString(pathInfo));
            int programId = Integer.parseInt(pathInfo[1]);
                String action = request.getParameter("action");
                if (action == null) {
                    action = "";
                }
                switch (action) {
                    case "addClass":
                        showAddClassForm(request,response,programId);
                        break;
                    case "deleteClass":
                        showDeleteClassForm(request,response,programId);
                        break;
                    case "editClass":
                        showEditClassForm(request,response,programId);
                        break;
                    default:
                        listClass(request,response,programId);
                        break;
                }
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response, int programId, int classId) {
        List<Student> classList = this.adminStudentService.findAllStudentOfAClass(classId);
        request.setAttribute("programId",programId);
        request.setAttribute("classId", classId);
        request.setAttribute("classList",classList);
        try {
            request.getRequestDispatcher("/admin/class_management/listClass.jsp").forward(request,
                    response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteStudentForm(HttpServletRequest request, HttpServletResponse response, int programId, int classId) {

    }

    private void showAddStudentForm(HttpServletRequest request, HttpServletResponse response, int programId, int classId) {
        request.setAttribute("programId", programId);
        request.setAttribute("classId",classId);
        try {
            request.getRequestDispatcher("/admin/student_management/addStudent.jsp").forward(request,
                    response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteClassForm(HttpServletRequest request, HttpServletResponse response, int programId) {
        int id = Integer.parseInt(request.getParameter("id"));
        ProgramClass programClass = this.adminService.findClassById(id);
        RequestDispatcher dispatcher;
        if (programClass == null) {
            request.setAttribute("message", "can't find the class to delete");
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            request.setAttribute("programClass",programClass);
            request.setAttribute("programId",programId);
            dispatcher =
                    request.getRequestDispatcher("/admin/class_management/deleteClass.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddClassForm(HttpServletRequest request, HttpServletResponse response, int programId) {
        try {
            request.getRequestDispatcher("/admin/class_management/addClass.jsp").forward(request,
                    response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listClass(HttpServletRequest request, HttpServletResponse response, int programId) {


        List<ProgramClass> classList = this.adminService.findAllClassOfAProgram(programId);
        request.setAttribute("programId",programId);
        request.setAttribute("classList",classList);
        try {
            request.getRequestDispatcher("/admin/class_management/listClass.jsp").forward(request,
                    response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditClassForm(HttpServletRequest request, HttpServletResponse response, int programId) {
    }

}
