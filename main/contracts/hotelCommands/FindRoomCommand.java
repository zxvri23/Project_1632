package bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.hotelCommands;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.Command;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileContext;

import java.time.LocalDate;
import java.util.Scanner;

public class FindRoomCommand implements Command {

    private FileContext context;
    private Scanner scanner;

    public FindRoomCommand(FileContext context, Scanner scanner) {
        this.context = context;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter the minimum beds you want: ");
        int min=Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the start date (yyyy-mm-dd): ");
        LocalDate start=LocalDate.parse(scanner.nextLine());

        System.out.print("Enter the end date (yyyy-mm-dd): ");
        LocalDate end=LocalDate.parse(scanner.nextLine());

        this.context.getState().find(min,start,end);
    }
}
