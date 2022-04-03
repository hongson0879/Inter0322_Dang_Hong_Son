package repository;



import model.House;
import model.Room;
import model.Villa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    Connection connection = this.baseRepository.getConnection();

    public void addVilla(Villa villa){
        try {
            String sql = "Insert into service values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, villa.getServiceID());
            preparedStatement.setString(2, villa.getServiceName());
            preparedStatement.setInt(3, villa.getServiceArea());
            preparedStatement.setDouble(4, villa.getServiceCost());
            preparedStatement.setInt(5, villa.getServiceMaxPeople());
            preparedStatement.setInt(6, villa.getRentType());
            preparedStatement.setInt(7, 1);
            preparedStatement.setString(8, villa.getStandardRoom());
            preparedStatement.setString(9, villa.getDescriptionOtherConvenience());
            preparedStatement.setDouble(10, villa.getPoolArea());
            preparedStatement.setInt(11, villa.getNumberOfFloors());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void addHouse(House house){
        try {
            String sql = "Insert into service values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, house.getServiceID());
            preparedStatement.setString(2, house.getServiceName());
            preparedStatement.setInt(3, house.getServiceArea());
            preparedStatement.setDouble(4, house.getServiceCost());
            preparedStatement.setInt(5, house.getServiceMaxPeople());
            preparedStatement.setInt(6, house.getRentType());
            preparedStatement.setInt(7, 2);
            preparedStatement.setString(8, house.getStandardRoom());
            preparedStatement.setString(9, house.getDescriptionOtherConvenience());
            preparedStatement.setNull(10, Types.NULL);
            preparedStatement.setInt(11, house.getNumberOfFloors());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void addRoom(Room room){
        try {
            String sql = "Insert into service values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, room.getServiceID());
            preparedStatement.setString(2, room.getServiceName());
            preparedStatement.setInt(3, room.getServiceArea());
            preparedStatement.setDouble(4, room.getServiceCost());
            preparedStatement.setInt(5, room.getServiceMaxPeople());
            preparedStatement.setInt(6, room.getRentType());
            preparedStatement.setInt(7, 3);
            preparedStatement.setNull(8, Types.NULL);
            preparedStatement.setNull(9, Types.NULL);
            preparedStatement.setNull(10, Types.NULL);
            preparedStatement.setNull(11, Types.NULL);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
