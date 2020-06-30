package controller.admin;

import model.Program;
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
                case "deleteProgram":
                    deleteProgram(request,response);
                    break;
                case "editProgram":
                    editProgram(request,response);
                    break;
                default:
                    break;
            }
        }
    }

    private void editProgram(HttpServletRequest request, HttpServletResponse response) {
        int programId = Integer.parseInt(request.getParameter("id"));
        String programName = request.getParameter("programName");
        Program program = this.adminService.findProgramById(programId);
        RequestDispatcher dispatcher;
        if(program == null){
            request.setAttribute("message","not found program to edit");
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            program.setProgramName(programName);
            this.adminService.editProgram(program);
            request.setAttribute("program", program);
            request.setAttribute("message", "Program information was updated");
            dispatcher = request.getRequestDispatcher("/admin/program_management/editProgram" +
                    ".jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProgram(HttpServletRequest request, HttpServletResponse response) {
       int id = Integer.parseInt(request.getParameter("id"));
       Program program = this.adminService.findProgramById(id);
       if (program == null) {
           try {
               request.getRequestDispatcher("/error-404.jsp").forward(request,response);
           } catch (ServletException | IOException e) {
               e.printStackTrace();
           }
       } else {
           this.adminService.removeProgram(id);
           try {
               response.sendRedirect("/admin/program");
           } catch (IOException exception) {
               exception.printStackTrace();
           }
       }
    }

    private void addProgram(HttpServletRequest request, HttpServletResponse response) {
        String programName = request.getParameter("programName");
        Program newProgram = new Program(programName);
        this.adminService.addProgram(newProgram);
        request.setAttribute("message","New program is added");
        try {
            request.getRequestDispatcher("/admin/program_management/addProgram.jsp").forward(request,
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
                case "deleteProgram":
                    showDeleteProgramForm(request,response);
                    break;
                case "editProgram":
                    showEditProgramForm(request,response);
                default:
                    listProgram(request,response);
                    break;
            }
        }
    }

    private void showEditProgramForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Program program = this.adminService.findProgramById(id);
        RequestDispatcher dispatcher;
        if(program == null){
            request.setAttribute("message", "Can't find the product to edit");
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            request.setAttribute("program", program);
            dispatcher = request.getRequestDispatcher("/admin/program_management/editProgram" +
                    ".jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteProgramForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Program program = this.adminService.findProgramById(id);
        RequestDispatcher dispatcher;
        if (program == null) {
            request.setAttribute("message", "can't find the id to delete");
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            request.setAttribute("program",program);
            dispatcher =
                    request.getRequestDispatcher("/admin/program_management/deleteProgram.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listProgram(HttpServletRequest request, HttpServletResponse response) {
        List<Program> programList = this.adminService.findAllProgram();
        request.setAttribute("programs",programList);
        try {
            request.getRequestDispatcher("/admin/program_management/listProgram.jsp").forward(request,
                    response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddProgramForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/admin/program_management/addProgram.jsp").forward(request,
                    response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
