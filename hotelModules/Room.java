package bg.tu_varna.sit.a1.f22621632.Project_1632.hotelModules;

public class Room {
    private String roomNumber;
    private int beds;
    private boolean isAvailable;
    private int guests;
    private String note;

    public Room(String roomNumber, int beds, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.beds = beds;
        this.isAvailable = true;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getBeds() {
        return beds;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getGuests() {
        return guests;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", beds=" + beds +
                ", isAvailable=" + isAvailable +
                ", guests=" + guests +
                ", note='" + note + '\'' +
                '}';
    }

    public void checkInRoom(){

    }
}

