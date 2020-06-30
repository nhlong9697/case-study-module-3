package controller.admin;

import model.Program;
import model.ProgramClass;
import service.admin.AdminDAO;
import service.admin.AdminService;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session.getAttribute("admin") == null) {
            request.setAttribute("not-login","Please login as admin");
            response.sendRedirect("/admin");
        } else {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "addClass":
                    addClass(request,response);
                    break;
                case "deleteClass":
                    deleteClass(request,response);
                    break;
                case "editClass":
                    editClass(request,response);
                    break;
                default:
                    break;
            }
        }
    }

    private void editClass(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteClass(HttpServletRequest request, HttpServletResponse response) {

    }

    private void addClass(HttpServletRequest request, HttpServletResponse response) {
        String pathInfo[] = request.getPathInfo().split("/");
        System.out.println(Arrays.toString(pathInfo));
        String id = pathInfo[1];
        int programId = Integer.parseInt(id);
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
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "addClass":
                    showAddClassForm(request,response);
                    break;
                case "deleteClass":
                    showDeleteClassForm(request,response);
                    break;
                case "editClass":
                    showEditClassForm(request,response);
                    break;
                default:
                    listClass(request,response);
                    break;
            }
        }
    }

    private void showDeleteClassForm(HttpServletRequest request, HttpServletResponse response
                                     ) {

    }

    private void showAddClassForm(HttpServletRequest request, HttpServletResponse response
                                  ) {
        try {
            request.getRequestDispatcher("/admin/class_management/addClass.jsp").forward(request,
                    response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listClass(HttpServletRequest request, HttpServletResponse response
                           ) {

        String pathInfo[] = request.getPathInfo().split("/");
        System.out.println(Arrays.toString(pathInfo));
        String id = pathInfo[1];
        int programId = Integer.parseInt(id);
        System.out.println(programId);
        List<ProgramClass> classList = this.adminService.findAllClass(programId);
        request.setAttribute("programId",programId);
        request.setAttribute("classList",classList);
        try {
            request.getRequestDispatcher("/admin/class_management/listClass.jsp").forward(request,
                    response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditClassForm(HttpServletRequest request, HttpServletResponse response
                                   ) {
    }


}
