package controller.admin;

import model.Program;
import service.admin.AdminDAO;
import service.admin.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProgramManagementServlet", urlPatterns = "/admin/program")
public class ProgramManagementServlet extends HttpServlet {
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
                case "addProgram":
                    addProgram(request,response);
                    break;
                default:
                    break;
            }
        }
    }

    private void addProgram(HttpServletRequest request, HttpServletResponse response) {
        String programName = request.getParameter("programName");
        Program newProgram = new Program(programName);
        this.adminService.add(newProgram);
        request.setAttribute("message","New program is added");
        try {
            request.getRequestDispatcher("class_management/addProgram.jsp").forward(request,
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
                case "addProgram":
                    showAddProgramForm(request,response);
                    break;
                default:
                    listProgram(request,response);
                    break;
            }
        }

    }

    private void listProgram(HttpServletRequest request, HttpServletResponse response) {
        List<Program> programList = this.adminService.findAllProgram();
        request.setAttribute("programs",programList);
        try {
            request.getRequestDispatcher("class_management/listProgram.jsp").forward(request,
                    response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddProgramForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("class_management/addProgram.jsp").forward(request,
                    response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
