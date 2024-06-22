package bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.defaultCommands;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.Command;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileContext;

public class FileSaveCommand implements Command {
    private FileContext context;
    private String input;

    public FileSaveCommand(FileContext context, String input) {
        this.context = context;
        this.input = input;
    }

    @Override
    public void execute() {
        this.context.getState().save(input);
    }
}
