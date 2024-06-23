package bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.hotelCommands;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.Command;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileContext;

import java.util.Scanner;


public class CheckOutCommand implements Command {
    private FileContext context;
    private Scanner scanner;

    public CheckOutCommand(FileContext context, Scanner scanner) {
        this.context = context;
        this.scanner = scanner;
    }

    @Override
    public void execute() {

        System.out.print("Enter the room you want to checkout: ");
        int roomNum=Integer.parseInt(scanner.nextLine());

        this.context.getState().checkOut(roomNum);
    }
}
