package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Activity {
    
    private LocalDateTime date;
    private String activty;
    private int id;

    public Activity(LocalDateTime date, int id, String activty) {
        this.date = date;
        this.id = id;
        this.activty = activty;
    }

    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    
    public LocalDateTime getRealDate() {
        return date;
    }
    
    public String getActivty() {
        return activty;
    }

    public int getId() {
        return id;
    }
    
    
    
    
    
    
    
    
    
    
    
}
