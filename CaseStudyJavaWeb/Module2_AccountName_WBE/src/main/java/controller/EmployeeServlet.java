package controller;

import model.Customer;
import model.Employee;
import service.EmployeeService;
import service.implement.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":{
                addEmployee(request, response);
                break;
            }
            case "delete":{
                deleteEmployee(request, response);
                break;
            }
            case "update":{
                updateCustomer(request, response);
                break;
            }
            default:
                getEmployeeList(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            default:
                getEmployeeList(request, response);
        }
    }

    private void getEmployeeList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        List<Employee> employeeList = employeeService.getEmployeeList();
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("/userInterface/employee.jsp").forward(request, response);
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        int idAdd = Integer.parseInt(request.getParameter("employeeID"));
        String name = request.getParameter("name");
        String dOB = request.getParameter("dob");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int position = Integer.parseInt(request.getParameter("position"));
        int educationDegree = Integer.parseInt(request.getParameter("educationDegree"));
        int division = Integer.parseInt(request.getParameter("division"));
        String username = request.getParameter("username");
        Employee employee = new Employee(idAdd, name, dOB, gender, idCard, phoneNumber, email, address,
                salary, position, educationDegree, division, username);
        employeeService.addEmployee(employee);
        response.sendRedirect("/employee");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = new Employee(id);
        employeeService.removeEmployee(employee);
        response.sendRedirect("/employee");
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int idSearch = Integer.parseInt(request.getParameter("id"));
        Employee employeeSearch = new Employee(idSearch);
        int idUpdate = Integer.parseInt(request.getParameter("employeeID"));
        String name = request.getParameter("name");
        String dOB = request.getParameter("dob");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int position = Integer.parseInt(request.getParameter("position"));
        int educationDegree = Integer.parseInt(request.getParameter("educationDegree"));
        int division = Integer.parseInt(request.getParameter("division"));
        String username = request.getParameter("username");
        Employee newEmployee = new Employee(idUpdate, name, dOB, gender, idCard, phoneNumber, email, address,
                salary, position, educationDegree, division, username);
        employeeService.updateEmployee(employeeSearch, newEmployee);
        response.sendRedirect("/employee");
    }
}
