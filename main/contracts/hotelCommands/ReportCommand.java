package bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.hotelCommands;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.Command;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileContext;

import java.time.LocalDate;
import java.util.Scanner;

public class ReportCommand implements Command {
    private FileContext context;
    private Scanner scanner;

    public ReportCommand(FileContext context, Scanner scanner) {
        this.context = context;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter start date (yyyy-mm-dd): ");
        LocalDate fromDate=LocalDate.parse(scanner.nextLine());

        System.out.print("Enter end date (yyyy-mm-dd): ");
        LocalDate toDate=LocalDate.parse(scanner.nextLine());


        this.context.getState().report(fromDate,toDate);
    }
}
