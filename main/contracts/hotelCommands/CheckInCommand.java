package bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.hotelCommands;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.Command;
import bg.tu_varna.sit.a1.f22621632.Project_1632.hotelModules.Hotel;
import bg.tu_varna.sit.a1.f22621632.Project_1632.hotelModules.Room;


import java.time.LocalDate;
import java.util.Scanner;

public class CheckInCommand implements Command {
    private Hotel hotel;
    private Scanner scanner;

    public CheckInCommand(Hotel hotel, Scanner scanner) {
        this.hotel = hotel;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try{
            System.out.print("Enter room number: ");
            int roomNumber=Integer.parseInt(scanner.nextLine());

            Room newRoom= hotel.getRoom(roomNumber);
            if(newRoom==null){
                System.out.println("Room number "+roomNumber+" does not exist.");
                return;
            }

            System.out.print("Enter check in date (yyyy-mm-dd): ");
            LocalDate fromDate=LocalDate.parse(scanner.nextLine());
            if(fromDate==null){
                return;
            }

            System.out.print("Enter check out date (yyyy-mm-dd): ");
            LocalDate toDate=LocalDate.parse(scanner.nextLine());
            if(toDate==null){
                return;
            }
            if(!toDate.isAfter(fromDate)){
                System.out.println("Check out date must be after check in date");
                return;
            }

            System.out.print("Enter note: ");
            String note=scanner.nextLine();

            System.out.print("Enter a number of guests(optional,please press enter to skip): ");
            String input=scanner.nextLine();
            int guests=input.isEmpty() ? hotel.getRoom(roomNumber).getBeds() :Integer.parseInt(input);

            hotel.checkIn(roomNumber,fromDate,toDate,note,guests);
            System.out.println("Check-in successful");
        }catch(NumberFormatException e){
            System.out.println("Invalid input.Please enter a valid number");
        }catch(Exception a){
            System.out.println("An error has occurred: "+a);
        }




    }
}
