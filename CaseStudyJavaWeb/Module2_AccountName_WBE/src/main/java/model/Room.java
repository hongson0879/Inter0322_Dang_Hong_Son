package model;

public class Room extends Service {

    public Room() {
    }

    public Room(int serviceID) {
        super(serviceID);
    }

    public Room(int serviceID,
                String serviceName,
                int serviceArea,
                double serviceCost,
                int serviceMaxPeople,
                int rentType) {
        super(serviceID, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentType);
    }
}
