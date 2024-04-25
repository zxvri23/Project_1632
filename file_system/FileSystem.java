package bg.tu_varna.sit.a1.f22621632.Project_1632.file_system;

import java.io.File;

public interface FileSystem {
    void open(File file);
    void close(File file);
    void save();
    void saveAs();
    void help();
    void exit();
}
