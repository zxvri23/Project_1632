package bg.tu_varna.sit.a1.f22621632.Project_1632.file_system;

import java.io.IOException;
import java.nio.file.Path;

public interface WriteFile {
    public void write(Path filePath, String data) throws IOException;
}
