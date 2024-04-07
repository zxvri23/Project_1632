package bg.tu_varna.sit.a1.f22621632;

import java.util.HashMap;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {


        Map <String,String> menu = new HashMap<>();

        menu.put(,"Check in room");
        menu.put(,"Available rooms");
        menu.put(,"Check out a room");
        menu.put(,"Report list");
        menu.put(,"Find a suitable room");
        menu.put(,"Find a VIP room");
        menu.put(,"Check for unavailable rooms");
        menu.put(,"Check room activities");
        menu.put(,"Exit"+"\n");

        Scanner scanner = new Scanner(System.in);
        String choice;


        do{
            for(Integer key : menu.keySet()){
                System.out.println(key+". "+menu.get(key));
            }

      

        

        scanner.close();
    }
}
