package bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.hotelCommands;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.Command;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileContext;

import java.time.LocalDate;
import java.util.Scanner;

public class UnavailabilityCommand implements Command {
    private FileContext context;
    private Scanner scanner;

    public UnavailabilityCommand(FileContext context, Scanner scanner) {
        this.context = context;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter room number: ");
        int roomNumber=Integer.parseInt(scanner.nextLine());

        System.out.print("Enter check in date (yyyy-mm-dd): ");
        LocalDate fromDate=LocalDate.parse(scanner.nextLine());

        System.out.print("Enter check out date (yyyy-mm-dd): ");
        LocalDate toDate=LocalDate.parse(scanner.nextLine());

        System.out.print("Enter note: ");
        String note=scanner.nextLine();

        this.context.getState().unavailability(roomNumber,fromDate,toDate,note);
    }
}
