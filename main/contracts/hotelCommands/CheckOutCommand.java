package bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.hotelCommands;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.Command;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileContext;



public class CheckOutCommand implements Command {
    private FileContext context;



    @Override
    public void execute() {
        this.context.getState().checkOut();
    }
}
