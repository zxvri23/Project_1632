package bg.tu_varna.sit.a1.f22621632.Project_1632.main.files;

import bg.tu_varna.sit.a1.f22621632.Project_1632.fileSystem.ReadFile;
import bg.tu_varna.sit.a1.f22621632.Project_1632.fileSystem.WriteFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWorker implements ReadFile, WriteFile {

    public FileWorker() throws FileNotFoundException{}

    @Override
    public void write(Path filePath, String data) throws IOException {
        try{
            Files.write(filePath,data.getBytes());
        }catch (IOException a){
            a.printStackTrace();
            throw a;
        }
    }

    @Override
    public String read(Path filePath) throws IOException {
        try{
            return Files.readString(filePath);
        }catch(IOException a){
            a.printStackTrace();
            throw a;
        }
    }

    public void createDirectory(Path path) throws IOException{
        if(Files.notExists(path)){
            Files.createDirectory(path);
        }
    }

    public void createFile(Path path) throws IOException{
        if(Files.notExists(path)){
            Files.createFile(path);
        }
    }
}
