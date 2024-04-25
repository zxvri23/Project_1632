package bg.tu_varna.sit.a1.f22621632.Project_1632.logger.modules;

import bg.tu_varna.sit.a1.f22621632.Project_1632.logger.contracts.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ErrorLogger implements Logger {
    private final String file = "logger.txt";

    private PrintWriter writer;

    public ErrorLogger() throws IOException{
        FileWriter fileWriter =new FileWriter(file);
        writer=new PrintWriter(fileWriter);
    }

    @Override
    public void log(String message) throws IOException {
        writer.println(message);
    }
}
