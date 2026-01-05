package Model;

import java.util.ArrayList;

public class Users {
    
    private int ID;
    private String name;
    private ArrayList<Integer> fRequestList;
    
    public Users(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.fRequestList = new ArrayList<>();
        
    }

    
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
    
    public ArrayList<Integer> getfRequestList() {
        return fRequestList;
    }
    
    
    
    
}
