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
