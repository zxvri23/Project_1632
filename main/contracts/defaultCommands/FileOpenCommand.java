package bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.defaultCommands;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.Command;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileContext;

import java.nio.file.Path;


public class FileOpenCommand implements Command {
    private FileContext context;
    private Path path;

    public FileOpenCommand(FileContext context, Path path) {
        this.context = context;
        this.path = path;
    }

    @Override
    public void execute() {
        this.context.getState().open(context,path);
    }
}
