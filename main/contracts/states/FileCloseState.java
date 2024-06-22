package bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.states;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.CommandSystemState;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.invoker.FileInvoker;

import java.nio.file.Path;

public class FileCloseState implements CommandSystemState {

    @Override
    public void open(FileInvoker file, Path pathFile) {
        FileOpenState fileOpenState=new FileOpenState();
        fileOpenState.open(file,pathFile);
        file.setState(fileOpenState);
    }

    @Override
    public void close(FileInvoker file) {
        System.out.println("You need to open a file before using this command!");
    }

    @Override
    public void save(String input) {
        System.out.println("You need to open a file before using this command!");
    }

    @Override
    public void saveAs(Path pathFile, String input) {
        System.out.println("You need to open a file before using this command!");
    }

    @Override
    public void help() {

    }

    @Override
    public void exit() {
        System.out.println("Exit is successful!");
    }


    @Override
    public void checkIn() {
        System.out.println("You need to open a file before using this command!");
    }

    @Override
    public void checkOut() {
        System.out.println("You need to open a file before using this command!");
    }


    @Override
    public void availability() {
        System.out.println("You need to open a file before using this command!");
    }

    @Override
    public void unavailability() {
        System.out.println("You need to open a file before using this command!");
    }

    @Override
    public void find() {
        System.out.println("You need to open a file before using this command!");
    }

    @Override
    public void findImportant() {
        System.out.println("You need to open a file before using this command!");
    }

    @Override
    public void report() {
        System.out.println("You need to open a file before using this command!");
    }
}
