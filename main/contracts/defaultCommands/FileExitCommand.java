package bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.defaultCommands;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.Command;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileContext;

public class FileExitCommand implements Command {

    private FileContext context;

    public FileExitCommand(FileContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        this.context.getState().exit();
    }
}
