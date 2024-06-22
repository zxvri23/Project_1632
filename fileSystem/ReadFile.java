package bg.tu_varna.sit.a1.f22621632.Project_1632.fileSystem;

import java.io.IOException;
import java.nio.file.Path;

public interface ReadFile {
    public String read(Path filePath) throws IOException;
}
