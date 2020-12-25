package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Empleado;
import logica.controladora.ManagerControl;

@WebServlet(name = "TakeIdEmployeeServlet", urlPatterns = {"/TakeIdEmployeeServlet"})
public class TakeIdEmployeeServlet extends HttpServlet {

    ManagerControl manager = ManagerControl.getInstante();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idChangeEmp"));
        Empleado emp = manager.getCemp().traerEmpleadoEnParticular(id);
        request.getSession().setAttribute("empleado", emp);
        response.sendRedirect("ChangeEmployee.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
