package bg.tu_varna.sit.a1.f22621632.Project_1632.contracts;

import java.io.File;

public interface CommandSystem {
    void open(File file);
    void close(File file);
    void save();
    void saveAs();
    void help();
    void exit();
}
