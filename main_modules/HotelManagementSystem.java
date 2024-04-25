package bg.tu_varna.sit.a1.f22621632.Project_1632.main_modules;

import bg.tu_varna.sit.a1.f22621632.Project_1632.hotel_modules.Room;

import java.util.ArrayList;
import java.util.List;

public class HotelManagementSystem {
    private List<Room> roomList;

    public HotelManagementSystem() {
        this.roomList = new ArrayList<>();
    }

    public List<Room> getRoomList() {
        return roomList;
    }

}
