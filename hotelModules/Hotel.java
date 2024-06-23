package bg.tu_varna.sit.a1.f22621632.Project_1632.hotelModules;

import java.time.LocalDate;
import java.util.*;

public class Hotel {
    private Map<Integer,Room> rooms=new HashMap<>();

    public Hotel(){
        addRoom(new Room(25,2));
        addRoom(new Room(44,4));
        addRoom(new Room(15,3));

    }


    public void addRoom(Room room){
        rooms.put(room.getRoomNumber(),room);
    }

    public Room getRoom(int roomNumber){
        return rooms.get(roomNumber);
    }

    public List<Room> getAvailableRooms(LocalDate from,LocalDate to){
        List<Room> roomArrayList=new ArrayList<>();
        for(Room room: rooms.values()){
            if(room.isAvailable(from,to)){
                roomArrayList.add(room);
            }
        }
        return roomArrayList;
    }

    public Map<Integer,Integer> generateReport(LocalDate from,LocalDate to){
        Map<Integer,Integer> report=new HashMap<>();
        for(Room room: rooms.values()){
            int daysUsed=room.getUsedDates(from,to);
            if(daysUsed>0){
                report.put(room.getRoomNumber(),daysUsed);
            }
        }
        return report;
    }

    public List<Room> getAllRooms(){
        return new ArrayList<>(rooms.values());
    }


}
