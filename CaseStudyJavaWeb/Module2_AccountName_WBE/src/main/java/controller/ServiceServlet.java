package controller;

import model.*;
import service.ServiceInterface;
import service.implement.ServiceInterfaceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    ServiceInterface serviceInterface = new ServiceInterfaceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":{
                addService(request, response);
                break;
            }
//            case "delete":{
//                deleteCustomer(request, response);
//                break;
//            }
//            case "update":{
//                updateCustomer(request, response);
//                break;
//            }
            default:
                getServiceList(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            default:
                getServiceList(request, response);
        }
    }

    private void getServiceList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/userInterface/service.jsp").forward(request, response);
    }

    private void addService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int serviceType = Integer.parseInt(request.getParameter("serviceType"));
        int serviceID = Integer.parseInt(request.getParameter("serviceID"));
        String serviceName = request.getParameter("name");
        int serviceArea = Integer.parseInt(request.getParameter("area"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        int rentType = Integer.parseInt(request.getParameter("rentType"));

        if(serviceType == 1){
            String standardRoom = request.getParameter("standard");
            String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
            int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
            double poolArea = Double.parseDouble(request.getParameter("poolArea"));
            Villa villa = new Villa(serviceID, serviceName, serviceArea, serviceCost,
                    serviceMaxPeople, rentType, standardRoom, descriptionOtherConvenience,
                    poolArea, numberOfFloors);
            serviceInterface.addVilla(villa);
        }
        if(serviceType == 2){
            String standardRoom = request.getParameter("standard");
            String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
            int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
            House house = new House(serviceID, serviceName, serviceArea, serviceCost, serviceMaxPeople,
                    rentType, standardRoom, descriptionOtherConvenience, numberOfFloors);
            serviceInterface.addHouse(house);
        }
        if(serviceType == 3){
            Room room = new Room(serviceID, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentType);
            serviceInterface.addRoom(room);
        }
        response.sendRedirect("/service");
    }
}
