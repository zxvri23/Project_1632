package bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.states;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.CommandSystemState;
import bg.tu_varna.sit.a1.f22621632.Project_1632.hotelModules.Booking;
import bg.tu_varna.sit.a1.f22621632.Project_1632.hotelModules.BookingManager;
import bg.tu_varna.sit.a1.f22621632.Project_1632.hotelModules.Hotel;
import bg.tu_varna.sit.a1.f22621632.Project_1632.hotelModules.Room;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileContext;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileWorker;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public class FileOpenState implements CommandSystemState {
    private Path file;
    private Hotel hotel;

    public void setFile(Path file) {
        this.file = file;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public void open(FileContext file, Path pathFile) {
        try{
            FileWorker fileWorker=new FileWorker();
            if(Files.notExists(pathFile)){
                fileWorker.createFile(pathFile);
            }
            this.file=pathFile;
            String fileRead=fileWorker.read(pathFile);

            this.hotel=new Hotel();


            System.out.println("Successfully opened the file,file content: ");
            System.out.println(fileRead);

        }catch (IOException a){
            System.out.println("Exception occurred: "+a);
        }
    }

    @Override
    public void close(FileContext invoker) {
        this.file=null;

        invoker.setState(new FileCloseState());
        System.out.println("Successfully closed the file");
    }

    @Override
    public void save(String input) {
        try{
            FileWorker fileWorker=new FileWorker();
            fileWorker.write(this.file,input);
            System.out.println("Successfully saved the file");

        }catch(IOException a){
            System.out.println("Exception occurred: "+a);
        }
    }

    @Override
    public void saveAs(Path pathFile, String input) {
        try{
            FileWorker fileWorker=new FileWorker();
            if(Files.notExists(pathFile)){
                fileWorker.createFile(pathFile);
            }
            fileWorker.write(pathFile,input);
            System.out.println("Successfully saved another file");
        }catch(IOException a){
            System.out.println("Exception occurred: "+a);
        }
    }

    @Override
    public void help() {
        System.out.println("The following commands are supported: \n"+
                "open <file>    opens file \n"+
                "close          closes currently opened file \n"+
                "save           saves the currently open file \n"+
                "saveas <file>  saves the currently open file in <file> \n"+
                "help           prints this information \n"+
                "exit           exists the program \n"+

                "checkIn        registers a room into the hotel system \n"+
                "availability   prints a list with available rooms \n"+
                "checkOut       unregisters a room from the hotel system \n"+
                "report         prints a list of rooms that have been used a certain time \n"+
                "find           finds a room with the needed beds \n" +
                "find!          finds a room IMMEDIATELY for a VIP  guest \n"+
                "unavailable    prints a taken room with a note \n");
    }

    @Override
    public void exit() {
        System.out.println("Exiting the program...");
    }


    @Override
    public void checkIn(int room, LocalDate fromDate, LocalDate toDate, String note, int guests) {
        if(hotel==null || file==null){
            System.out.println("Please open a file first!");
            return;
        }

        Room newRoom=hotel.getRoom(room);

        if(newRoom==null){
            System.out.println("Room number "+room+" does not exist.");
            return;
        }

        if(!newRoom.isAvailable(fromDate,toDate)){
            System.out.println("Room number "+ room+" is not available in those dates.");
            return;
        }

        if(guests==-1){
            guests=newRoom.getBeds();
        }

        newRoom.book(room,fromDate,toDate,note,guests);
        newRoom.setOccupied(true);
        System.out.println("Successful check-in: \n"+
                "checkin "+ room+" "+ fromDate+ " "+toDate+" "+note);
    }

    @Override
    public void checkOut(int roomNumber) {

        if(hotel==null || file==null){
            System.out.println("Please open a file first!");
            return;
        }
        Room newRoom=hotel.getRoom(roomNumber);

        if(newRoom==null){
            System.out.println("Room number "+roomNumber+ "does not exist.");
            return;
        }

        System.out.println("Before checkout,room "+roomNumber+" is occupied: "+ newRoom.isOccupied());

        if(!newRoom.isOccupied()){
            System.out.println("Room number "+ roomNumber+ " is not occupied.");
            return;
        }

        newRoom.setOccupied(false);
        System.out.println("After checkout,room "+roomNumber+" is occupied: "+ newRoom.isOccupied());
        newRoom.checkOut();
        System.out.println("Successful check out for room: "+roomNumber);

    }


    @Override
    public void availability(LocalDate date) {
        if(hotel==null || file==null){
            System.out.println("Please open a file first!");
            return;
        }

        LocalDate current;
        if(date!=null){
            current=date;
        }
        else {
            current=LocalDate.now();
        }
        List<Room> available=hotel.getAvailableRooms(current,current);

        if(available.isEmpty()){
            System.out.println("No rooms available on "+current);
        }
        else{
            System.out.println("Available rooms on "+current);
            for(Room room :available){
                System.out.println(room.getRoomNumber()+ " and it has beds' counter as: "+room.getBeds());
            }
        }


    }

    @Override
    public void unavailability(int roomNumber, LocalDate from, LocalDate to, String note) {
        if(hotel==null || file==null){
            System.out.println("Please open a file first!");
            return;
        }
    }


    @Override
    public void find(int beds, LocalDate from, LocalDate to) {
        if(hotel==null || file==null){
            System.out.println("Please open a file first!");
            return;
        }

        Room bestRoom=null;

        for(Room room: hotel.getAllRooms()){
            if(room.getBeds()>=beds && room.isAvailable(from,to)){
                if(bestRoom==null || room.getBeds()<bestRoom.getBeds()){
                    bestRoom=room;
                }
            }
        }

        if(bestRoom!=null){
            System.out.println("Found room: "+ bestRoom.getRoomNumber()
            +" with " + bestRoom.getBeds() + " beds available from " + from
            +" to "+to);
        }else{
            System.out.println("No room available!");
        }


    }

    @Override
    public void findImportant(int beds, LocalDate from, LocalDate to) {
        if(hotel==null || file==null){
            System.out.println("Please open a file first!");
            return;
        }

        BookingManager bookingManager=new BookingManager(hotel);

        if(bookingManager.tryToRearrangeAndReserve(beds,from,to)){
            System.out.println("Emergency booking successfully rearranged.");
        }
        else{
            System.out.println("Unable to rearrange bookings with the current request.");
        }



    }

    @Override
    public void report(LocalDate from,LocalDate to) {
        if(hotel==null || file==null){
            System.out.println("Please open a file first!");
            return;
        }

        Map<Integer,Integer> report=hotel.generateReport(from,to);
        if(report.isEmpty()){
            System.out.println("No usage data available.");
        }

        for(Map.Entry<Integer,Integer> entry : report.entrySet()){
            System.out.println("Room "+ entry.getKey() + " was used for: "+ entry.getValue()+ " days.");
        }


    }
}
