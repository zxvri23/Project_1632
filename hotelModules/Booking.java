package bg.tu_varna.sit.a1.f22621632.Project_1632.hotelModules;

import java.time.LocalDate;

public class Booking {
    private int roomNumber;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String note;
    private  int guests;

    public Booking(int roomNumber, LocalDate fromDate, LocalDate toDate, String note, int guests) {
        this.roomNumber = roomNumber;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.note = note;
        this.guests = guests;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public String getNote() {
        return note;
    }

    public int getGuests() {
        return guests;
    }

    public boolean overlaps(LocalDate from,LocalDate to){
        return (this.fromDate.isBefore(to) && from.isBefore(this.toDate));
    }

    public int getDaysPeriod(LocalDate from,LocalDate to){
        LocalDate maxStart;
        LocalDate maxEnd;
        int count=0;


        if(fromDate.isAfter(from)){
            maxStart=fromDate;
        }else{
            maxStart=from;
        }

        if(toDate.isBefore(to)){
            maxEnd=toDate;
        }else{
            maxEnd=to;
        }


        if(maxStart.isAfter(maxEnd)){
            return 0;
        }

        LocalDate currentDay=maxStart;
        while(!currentDay.isAfter(maxEnd)){
            count++;
            currentDay=currentDay.plusDays(1);
        }
        return count;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "roomNumber='" + roomNumber + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", note='" + note + '\'' +
                ", guests=" + guests +
                '}';
    }
}
