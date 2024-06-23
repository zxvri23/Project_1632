package bg.tu_varna.sit.a1.f22621632.Project_1632.hotelModules;

import java.time.LocalDate;

public class BookingManager {
    private Hotel hotel;

    public BookingManager(Hotel hotel) {
        this.hotel = hotel;
    }


    public boolean tryToRearrangeAndReserve(int beds,LocalDate from,LocalDate to){
        for(Room room: hotel.getAllRooms()){
            if(room.getBeds()>=beds && room.isAvailable(from,to)){
                System.out.println("Room " +room.getRoomNumber()+" is reserved.");
                return true;
            }
        }
        return rearrangeBookings(beds,from,to);
    }

    public boolean rearrangeBookings(int beds, LocalDate from,LocalDate to){
        for(Room  room : hotel.getAllRooms()){
            if(room.getBeds()>=beds){
                if(room.tryToRearrange(from,to)){
                    System.out.println("Bookings rearranged in: "+ room.getRoomNumber());
                    return true;
                }
            }
        }
        return false;
    }
}
