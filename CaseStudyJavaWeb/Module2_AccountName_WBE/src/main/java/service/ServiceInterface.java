package service;

import model.House;
import model.Room;
import model.Villa;

public interface ServiceInterface {
    public void addVilla(Villa villa);
    public void addHouse(House house);
    public void addRoom(Room room);
}
