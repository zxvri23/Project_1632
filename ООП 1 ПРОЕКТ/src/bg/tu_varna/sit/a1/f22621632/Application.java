package bg.tu_varna.sit.a1.f22621632;

import java.util.HashMap;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {


        HashMap <Integer,String> menu = new HashMap<>();

        menu.put(1,"Check in room");
        menu.put(2,"Available rooms");
        menu.put(3,"Check out a room");
        menu.put(4,"Report list");
        menu.put(5,"Find a suitable room");
        menu.put(6,"Find a VIP room");
        menu.put(7,"Check for unavailable rooms");
        menu.put(8,"Check room activities");
        menu.put(9,"Exit"+"\n");

        Scanner scanner = new Scanner(System.in);
        int choice;


        do{
            for(Integer key : menu.keySet()){
                System.out.println(key+". "+menu.get(key));
            }

            System.out.println("Enter your choice (1-9): ");
            choice =scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Number of room: "+ "\n");

                    System.out.println("Date: "+"\n");


                    break;
                case 2:
                    System.out.println("Date: ");

                    break;
                case 3:
                    System.out.println("Check out of room number: ");

                    break;
                case 4:


                    break;
                case 5:
                    System.out.println("Number of beds needed: "+ "\n");

                    break;
                case 6:


                    break;
                case 7:
                    System.out.println("Number of room: "+"\n");

                    System.out.println("Date: ");

                    break;
                case 8:
                    System.out.println("Number of room: "+"\n");

                    break;
                case 9:
                    System.out.println("Exiting and ending the program");
                    break;
                default:
                    System.out.println("Unavailable option! Please choice an existing one! :) "+ "\n");
                    break;

            }
        }while (choice!=9);

        scanner.close();
    }
}
