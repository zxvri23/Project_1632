package bg.tu_varna.sit.a1.f22621632.main_modules;

import bg.tu_varna.sit.a1.f22621632.modules.Room;

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
