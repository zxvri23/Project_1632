package bg.tu_varna.sit.a1.f22621632.Project_1632.contracts;

import bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.invoker.FileInvoker;

import java.io.File;
import java.nio.file.Path;

public interface CommandSystemState {
    void open(FileInvoker file, Path pathFile);
    void close(FileInvoker file);
    void save(String input);
    void saveAs(Path pathFile,String input);
    void help();
    void exit();

    void checkIn();
    void checkOut();
    void availability();
    void find();
    void findImportant();
    void report();
    void unavailability();

}
