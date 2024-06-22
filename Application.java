package bg.tu_varna.sit.a1.f22621632.Project_1632;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.Command;
import bg.tu_varna.sit.a1.f22621632.Project_1632.enums.CommandsType;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.defaultCommands.*;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.contracts.hotelCommands.*;
import bg.tu_varna.sit.a1.f22621632.Project_1632.main.files.FileContext;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String command;
        FileContext fileContext=new FileContext();
        Scanner scanner=new Scanner(System.in);

        CommandsType commandsType= CommandsType.HELP;
        String text="something new";
        String fileFolder="C:\\Users\\Lenovo\\IdeaProjects\\ООП 1 ПРОЕКТ\\src\\bg\\tu_varna\\sit\\a1\\f22621632\\Project_1632\\";
        Path defaultPath=Path.of("C:\\Users\\Lenovo\\IdeaProjects\\ООП 1 ПРОЕКТ\\src\\bg\\tu_varna\\sit\\a1\\f22621632\\Project_1632\\");
        Path filePath=defaultPath;
        Map<CommandsType, Command> menu=new HashMap<>();


        do{
            System.out.println("\nChoose a command from the once bellow: ");
            System.out.println("-> open file.txt" + "\n-> close" +
                    "\n-> save" + "\n-> saveas file.txt" +
                    "\n-> help" + "\n-> checkIn" +
                    "\n-> checkOut" + "\n-> availability" +
                    "\n-> report" + "\n-> find " +
                    "\n-> find! " + "\n-> unavailability" +
                    "\n-> exit\n");
            System.out.print("Your choice -> ");

            command=scanner.nextLine().toUpperCase();
            String[] inputs=command.split(" ");
            try{
                commandsType=CommandsType.valueOf(inputs[0]);
            }catch(Exception e){
                System.out.println("This command does not exist!");
                continue;
            }
            if(inputs.length>1){
                filePath=Path.of(fileFolder+inputs[1]);
            }else{
                filePath=defaultPath;
            }

            menu.put(CommandsType.OPEN,new FileOpenCommand(fileContext,filePath));
            menu.put(CommandsType.CLOSE,new FileCloseCommand(fileContext));
            menu.put(CommandsType.SAVE,new FileSaveCommand(fileContext,text));
            menu.put(CommandsType.SAVEAS,new FileSaveAsCommand(fileContext,filePath,text));
            menu.put(CommandsType.HELP,new FileHelpCommand(fileContext));
            menu.put(CommandsType.EXIT,new FileExitCommand(fileContext));


            menu.put(CommandsType.CHECKIN,new CheckInCommand());
            menu.put(CommandsType.AVAILABILITY,new AvailabilityCommand());
            menu.put(CommandsType.CHECKOUT,new CheckOutCommand());
            menu.put(CommandsType.REPORT,new ReportCommand());
            menu.put(CommandsType.FIND_ROOM,new FindRoomCommand());
            menu.put(CommandsType.FIND_EMERGENCY_ROOM,new FindImportantRoomCommand());
            menu.put(CommandsType.UNAVAILABLE,new UnavailabilityCommand());




            fileContext.execute(menu.get(commandsType));
        }while(!commandsType.equals(CommandsType.EXIT));





    }
}
