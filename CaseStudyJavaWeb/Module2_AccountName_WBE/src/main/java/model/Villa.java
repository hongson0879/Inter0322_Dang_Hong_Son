package model;

public class Villa extends Service {
    private String standardRoom;
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(int serviceID) {
        super(serviceID);
    }

    public Villa(int serviceID,
                 String serviceName,
                 int serviceArea,
                 double serviceCost,
                 int serviceMaxPeople,
                 int rentType,
                 String standardRoom,
                 String descriptionOtherConvenience,
                 double poolArea,
                 int numberOfFloors) {
        super(serviceID, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentType);
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
