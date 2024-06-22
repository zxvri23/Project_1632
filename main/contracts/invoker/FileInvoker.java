package bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.invoker;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.Command;
import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.CommandSystemState;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.states.FileCloseState;

public class FileInvoker {
    private CommandSystemState state;

    public FileInvoker() {
        this.state = new FileCloseState();
    }

    public CommandSystemState getState() {
        return state;
    }

    public void setState(CommandSystemState state) {
        this.state = state;
    }

    public void execute(Command command){
        command.execute();
    }
}
