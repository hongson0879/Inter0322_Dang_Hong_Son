package service.implement;

import model.House;
import model.Room;
import model.Villa;
import repository.ServiceRepository;
import service.ServiceInterface;

public class ServiceInterfaceImpl implements ServiceInterface {
    ServiceRepository serviceRepository = new ServiceRepository();

    @Override
    public void addVilla(Villa villa) {
        serviceRepository.addVilla(villa);
    }

    @Override
    public void addHouse(House house) {
        serviceRepository.addHouse(house);
    }

    @Override
    public void addRoom(Room room) {
        serviceRepository.addRoom(room);
    }
}
