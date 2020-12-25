package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Empleado;
import logica.controladora.ManagerControl;

@WebServlet(name = "ListEmployeeServlet", urlPatterns = {"/ListEmployeeServlet"})
public class ListEmployeeServlet extends HttpServlet {

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
        List<Empleado> listEmp = manager.getCemp().traerEmpleado();
        request.getSession().setAttribute("listEmployee", listEmp);
        response.sendRedirect("ChangeTakeEmployee.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
