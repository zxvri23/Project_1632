package bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.states;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.CommandSystemState;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileContext;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileWorker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOpenState implements CommandSystemState {
    private Path file;

    @Override
    public void open(FileContext file, Path pathFile) {
        try{
            FileWorker fileHelper=new FileWorker();
            if(Files.notExists(pathFile)){
                fileHelper.createFile(pathFile);
            }
            this.file=pathFile;
            String fileRead=fileHelper.read(pathFile);

            System.out.println("Successfully opened the file,file content: ");
            System.out.println(fileRead);

        }catch (IOException a){
            System.out.println("Exception occurred: "+a);
        }
    }

    @Override
    public void close(FileContext invoker) {
        this.file=null;

        invoker.setState(new FileCloseState());
        System.out.println("Successfully closed the file");
    }

    @Override
    public void save(String input) {
        try{
            FileWorker fileWorker=new FileWorker();
            fileWorker.write(this.file,input);
            System.out.println("Successfully saved the file");

        }catch(IOException a){
            System.out.println("Exception occurred: "+a);
        }
    }

    @Override
    public void saveAs(Path pathFile, String input) {
        try{
            FileWorker fileWorker=new FileWorker();
            if(Files.notExists(pathFile)){
                fileWorker.createFile(pathFile);
            }
            fileWorker.write(pathFile,input);
            System.out.println("Successfully saved another file");
        }catch(IOException a){
            System.out.println("Exception occurred: "+a);
        }
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
    public void checkIn() {
        System.out.println("tYPE IN UR ROOM: ");
    }

    @Override
    public void checkOut() {

    }


    @Override
    public void availability() {

    }

    @Override
    public void unavailability() {

    }

    @Override
    public void find() {

    }

    @Override
    public void findImportant() {


    }

    @Override
    public void report() {

    }
}
