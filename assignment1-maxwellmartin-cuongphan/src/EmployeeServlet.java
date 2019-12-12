import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fromPage = request.getParameter("fromPage");
        String url = "/index.jsp";

        if (fromPage != null) {
            if (fromPage.equals("index")) {
                Employee employee = new Employee();
                ArrayList<Integer> numberOfExceptions = new ArrayList<>();

                String firstName = request.getParameter("fnText");
                String lastName = request.getParameter("lnText");

                employee.setFirstName(firstName);
                employee.setLastName(lastName);

                try {
                    employee.setMonthlySalary(Integer.parseInt(request.getParameter("msText")));
                }
                catch (Exception ex) {
                    numberOfExceptions.add(1);
                }

                try {
                    employee.setMonthsOfPayment(Integer.parseInt(request.getParameter("mpText")));
                }
                catch (Exception ex) {
                    numberOfExceptions.add(1);
                }

                try {
                    employee.setYearlySalary(Employee.calculateYearlySalary(employee.getMonthlySalary(), employee.getMonthsOfPayment()));
                }
                catch (Exception ex) {
                    numberOfExceptions.add(1);
                }

                if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty() && numberOfExceptions.size() == 0) {
                    url = "/results.jsp";
                    request.setAttribute("employee", employee);
                }
            }
            else if (fromPage.equals("results")){
                url = "/welcome.html";
            }
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
