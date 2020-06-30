package controller.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "StudentManagementServlet", urlPatterns = {"/admin/program/*/class/*","/admin" +
        "/program/*/class/*/student"})
public class StudentManagementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session.getAttribute("admin") == null) {
            request.setAttribute("not-login","Please login as admin");
            response.sendRedirect("/admin");
        } else {
            String pathInfo[] = request.getPathInfo().split("/");
            System.out.println(Arrays.toString(pathInfo));
            String id = pathInfo[1];
            int classId = Integer.parseInt(id);
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "addClass":
                    break;
                case "deleteClass":
                    break;
                case "editClass":
                    break;
                default:
                    listStudent(request,response,classId);
                    break;
            }
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response, int classId) {
        try {
            request.getRequestDispatcher("/admin/student_management/listStudent.jsp").forward(request
                    ,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
