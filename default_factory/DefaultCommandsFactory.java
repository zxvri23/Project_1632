package bg.tu_varna.sit.a1.f22621632.Project_1632.default_factory;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.Command;
import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.CommandSystem;
import bg.tu_varna.sit.a1.f22621632.Project_1632.enums.DefaultCommands;

public class DefaultCommandsFactory {

    public static Command getWorking(DefaultCommands defaultCommands){
        Command command=new CloseFactory();

        switch (defaultCommands){
            case CLOSE -> new CloseFactory();
            case OPEN -> new OpenFactory();
            case SAVE -> new SaveFactory();
            case SAVEAS -> new SaveAsFactory();
            case HELP -> new HelpFactory();
            case EXIT -> new ExitFactory();
        }
        return command;
    }
}
