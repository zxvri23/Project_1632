package bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.states;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.CommandSystemState;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileContext;

import java.nio.file.Path;
import java.time.LocalDate;

public class FileCloseState implements CommandSystemState {

    @Override
    public void open(FileContext file, Path pathFile) {
        FileOpenState fileOpenState=new FileOpenState();
        fileOpenState.open(file,pathFile);
        file.setState(fileOpenState);
    }

    @Override
    public void close(FileContext invoker) {
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

        System.out.println("The following commands are supported: \n"+
                "open <file>    opens file \n"+
                "close          closes currently opened file \n"+
                "save           saves the currently open file \n"+
                "saveas <file>  saves the currently open file in <file> \n"+
                "help           prints this information \n"+
                "exit           exists the program \n"+

                "checkIn        registers a room into the hotel system \n"+
                "availability   prints a list with available rooms \n"+
                "checkOut       unregisters a room from the hotel system \n"+
                "report         prints a list of rooms that have been used a certain time \n"+
                "find           finds a room with the needed beds \n" +
                "find!          finds a room IMMEDIATELY for a VIP  guest \n"+
                "unavailable    prints a taken room with a note \n");
    }

    @Override
    public void exit() {
        System.out.println("Exiting the program...");
    }


    @Override
    public void checkIn(int room, LocalDate fromDate, LocalDate toDate, String note, int guests) {
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
