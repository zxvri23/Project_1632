package bg.tu_varna.sit.a1.f22621632.Project_1632.hotelModules;


import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomNumber;
    private int beds;
    List<Booking> bookingList=new ArrayList<>();

    public Room(int roomNumber,int beds) {
        this.roomNumber=roomNumber;
        this.beds = beds;

    }

    public int getBeds() {
        return beds;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void addBooking(Booking booking){
        bookingList.add(booking);
    }

    public void removeBooking(Booking booking){
        bookingList.remove(booking);
    }


    @Override
    public String toString() {
        return "Room{" +
                "beds=" + beds +
                ", bookingList=" + bookingList +
                '}';
    }
}

