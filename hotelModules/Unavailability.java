package bg.tu_varna.sit.a1.f22621632.Project_1632.hotelModules;

import java.time.LocalDate;

public class Unavailability {
    private LocalDate from;
    private LocalDate to;
    private  String note;

    public Unavailability(LocalDate from, LocalDate to, String note) {
        this.from = from;
        this.to = to;
        this.note = note;
    }


}
