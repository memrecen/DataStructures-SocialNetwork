package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    
    private int userID;
    private String name, contant;
    public LocalDateTime postDate;

    public Post(int userID, String name, String contant, LocalDateTime postDate) {
        this.userID = userID;
        this.name = name;
        this.contant = contant;
        this.postDate = postDate;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getContant() {
        return contant;
    }

    public String getPostDate() {
        return postDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    
    public LocalDateTime getRawPostDate() {
        return postDate;
    }
    
    
    
}
