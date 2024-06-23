package bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.hotelCommands;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.Command;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileContext;

import java.time.LocalDate;

public class AvailabilityCommand implements Command {

    private FileContext context;
    private LocalDate date;

    public AvailabilityCommand(FileContext context, LocalDate date) {
        this.context = context;
        this.date = date;
    }

    @Override
    public void execute() {
        this.context.getState().availability(date);
    }
}
