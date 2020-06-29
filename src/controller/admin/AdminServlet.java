package controller.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("123")) {
            session.setAttribute("admin",true);
            response.sendRedirect("/admin");
        } else {
            request.setAttribute("fail-login","Wrong username and password");
            request.getRequestDispatcher("admin/adminLogin.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session.getAttribute("admin") == null) {
            request.setAttribute("not-login","Please login as admin");
            request.getRequestDispatcher("admin/adminLogin.jsp").forward(request,response);
        } else {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "addClass":
                    showAddClassForm(request,response);
                    break;
                case "addTest":
                    showAddTestForm(request,response);
                    break;
                case "addProgram":
                    showAddProgramForm(request,response);
                    break;
                default:
                    listTask(request,response);
            }
        }
    }

    private void showAddProgramForm(HttpServletRequest request, HttpServletResponse response) {
        //TODO: add show add program form
        try {
            request.getRequestDispatcher("admin/addProgram.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddTestForm(HttpServletRequest request, HttpServletResponse response) {
       //TODO: add show add test form
    }

    private void showAddClassForm(HttpServletRequest request, HttpServletResponse response) {
       //TODO: add show add class form
    }

    private void listTask(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("admin/adminManage.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
