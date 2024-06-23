package bg.tu_varna.sit.a1.f22621632.Project_1632.hotelModules;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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

    public void checkIn(int room, LocalDate fromDate, LocalDate toDate, String note, int guests) {
        Room newRoom=getRoom(room);

        if(newRoom!=null){
            newRoom.addBooking(new Booking(room,fromDate,toDate,note,guests));
        }
        else{
            System.out.println("Room number "+room+" does not exist.");
        }
    }


}
