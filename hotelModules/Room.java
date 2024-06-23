package bg.tu_varna.sit.a1.f22621632.Project_1632.hotelModules;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomNumber;
    private int beds;
    private boolean occupied;
    private List<Unavailability> unavailabilityList=new ArrayList<>();
    private List<Booking> bookingList=new ArrayList<>();


    public Room(int roomNumber,int beds) {
        this.roomNumber=roomNumber;
        this.beds = beds;

    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getBeds() {
        return beds;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    /*public List<Booking> getBookingList() {
        return bookingList;
    }*/


    public boolean isAvailable(LocalDate from,LocalDate to){
        for(Booking booking: bookingList){
            if(booking.overlaps(from,to)){
                return false;
            }
        }
        return true;
    }

    public void book(int roomNumber,LocalDate from,LocalDate to,String note,int guests){
        bookingList.add(new Booking(roomNumber,from,to,note,guests));
    }


    public void checkOut(){
        this.occupied=false;
        this.bookingList.clear();
    }

    public int getUsedDates(LocalDate from,LocalDate to){
        int count=0;
        for(Booking booking:bookingList){
            if(booking.overlaps(from,to)){
                count+=booking.getDaysPeriod(from,to);
            }
        }
        return count;

    }


    public boolean tryToRearrange(LocalDate from,LocalDate to){

        boolean rearrange=false;
        for(int i=0;i<bookingList.size();i++){
            Booking booking=bookingList.get(i);
            if(booking.getFromDate().isBefore(to) && booking.getToDate().isAfter(from)){
                bookingList.remove(i);
                rearrange=true;
                break;
            }
        }
        return rearrange;

    }

    public void addUnavailableRoom(LocalDate from,LocalDate to,String note){
        unavailabilityList.add(new Unavailability(from,to,note));
    }
}

