package bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.defaultCommands;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.Command;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileContext;

import java.nio.file.Path;

public class FileSaveAsCommand implements Command {
    private FileContext context;
    private Path path;
    private String input;

    public FileSaveAsCommand(FileContext context, Path path, String input) {
        this.context = context;
        this.path = path;
        this.input = input;
    }

    @Override
    public void execute() {
        this.context.getState().saveAs(path,input);
    }
}
