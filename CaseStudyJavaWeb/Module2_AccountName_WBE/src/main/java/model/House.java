package model;

public class House extends Service {
    private String standardRoom;
    private String descriptionOtherConvenience;
    private int numberOfFloors;

    public House() {
    }

    public House(int serviceID) {
        super(serviceID);
    }

    public House(int serviceID,
                 String serviceName,
                 int serviceArea,
                 double serviceCost,
                 int serviceMaxPeople,
                 int rentType,
                 String standardRoom,
                 String descriptionOtherConvenience,
                 int numberOfFloors) {
        super(serviceID, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentType);
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
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

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
