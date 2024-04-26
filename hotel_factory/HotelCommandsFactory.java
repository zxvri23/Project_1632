package bg.tu_varna.sit.a1.f22621632.Project_1632.hotel_factory;

import bg.tu_varna.sit.a1.f22621632.Project_1632.contracts.Command;
import bg.tu_varna.sit.a1.f22621632.Project_1632.enums.HotelCommands;

public class HotelCommandsFactory {
    public static Command getWorking(HotelCommands hotelCommands){
        Command command=new CheckInFactory();

        switch (hotelCommands){
            case CHECKIN -> new CheckInFactory();
            case CHECKOUT -> new CheckOutFactory();
            case AVAILABILITY -> new AvailabilityFactory();
            case UNAVAILABLE -> new UnavailabilityFactory();
            case FIND_ROOM -> new FindFactory();
            case FIND_EMERGENCY_ROOM -> new FindImmediatelyFactory();
            case REPORT -> new ReportFactory();
        }
        return command;
    }
}
