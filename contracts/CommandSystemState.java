package bg.tu_varna.sit.a1.f22621632.Project_1632.contracts;

import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileContext;

import java.nio.file.Path;
import java.time.LocalDate;

public interface CommandSystemState {
    void open(FileContext file, Path pathFile);
    void close(FileContext invoker);
    void save(String input);
    void saveAs(Path pathFile,String input);
    void help();
    void exit();

    void checkIn(int room, LocalDate fromDate, LocalDate toDate, String note, int guests);
    void checkOut(int roomNumber);
    void availability();
    void find();
    void findImportant();
    void report();
    void unavailability();

}
