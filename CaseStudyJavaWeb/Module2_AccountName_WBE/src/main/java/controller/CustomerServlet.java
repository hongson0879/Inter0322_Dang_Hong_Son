package controller;

import model.Customer;
import service.CustomerService;
import service.implement.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":{
                addCustomer(request, response);
                break;
            }
            case "delete":{
                deleteCustomer(request, response);
                break;
            }
            case "update":{
                updateCustomer(request, response);
                break;
            }
            default:
                getCustomerList(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            default:
                getCustomerList(request, response);
        }
    }
    private void getCustomerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Customer> customerList = customerService.getCustomerList();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/userInterface/customer.jsp").forward(request, response);
    }

    private  void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int idAdd = Integer.parseInt(request.getParameter("customerID"));
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int type = Integer.parseInt(request.getParameter("type"));
        String address = request.getParameter("address");
        Customer customer = new Customer(idAdd, name, dob, gender, idCard, phone, email, address, type);
        customerService.addCustomer(customer);
        response.sendRedirect("/customer");
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int idDelete = Integer.parseInt(request.getParameter("id"));
        Customer customer = new Customer(idDelete);
        customerService.removeCustomer(customer);
        response.sendRedirect("/customer");
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int idSearch = Integer.parseInt(request.getParameter("id"));
        Customer customerSearch = new Customer(idSearch);
        int idUpdate = Integer.parseInt(request.getParameter("customerID"));
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int type = Integer.parseInt(request.getParameter("type"));
        String address = request.getParameter("address");
        Customer newCustomer = new Customer(idUpdate, name, dob, gender, idCard, phone, email, address, type);
        customerService.updateCustomer(customerSearch, newCustomer);
        response.sendRedirect("/customer");
    }

}
