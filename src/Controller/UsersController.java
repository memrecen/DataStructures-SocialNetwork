package Controller;

import Model.Activity;
import Model.Post;
import Model.Users;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class UsersController {
    
    public static Hashtable<Integer, Users> userMap = new Hashtable<>();
    public static Map<Users, ArrayList<Users>> friendshipGraph = new HashMap<>();
    public static LinkedList<Post> posts = new LinkedList<>();
    public static PriorityQueue<Activity> activities = new PriorityQueue<>((a1, a2) -> a1.getRealDate().compareTo(a2.getRealDate()));
    public static int uid = 0;

    public void addUser(int id, String name){
        userMap.put(id, new Users(id, name));
        friendshipGraph.put(userMap.get(id), new ArrayList<>());
        System.out.println("\nUser registered successfully: ID = " + id + ", Name = " + name);
    }

    public void addFriend(int userID1, int userID2) {
        if (userMap.containsKey(userID1) && userMap.containsKey(userID2)) {
            friendshipGraph.get(userMap.get(userID1)).add(userMap.get(userID2));
            friendshipGraph.get(userMap.get(userID2)).add(userMap.get(userID1));
            System.out.println("\nFriendship established between " + userID1 + " and " + userID2);
        }
    }
    
    public void removeUser(int id){
        
        for (Users user : userMap.values()) {
            if(friendshipGraph.get(user).contains(userMap.get(id))){
                friendshipGraph.get(user).remove(friendshipGraph.get(user).indexOf(userMap.get(id)));
            }
            if(user.getfRequestList().contains(id)){
                user.getfRequestList().remove(user.getfRequestList().indexOf(id));
            }
        }
        for (Post post : posts) {
            if(post.getUserID()==id){
                posts.remove(post);
            }
        }
        ArrayList<Activity> aar = new ArrayList<>();
        for (Activity activity : activities) {
            if (activity.getId()==id) {
                aar.add(activity);
            }
        }
        for (Activity activity : aar) {
            activities.remove(activity);
        }
        userMap.remove(id);
        friendshipGraph.remove(userMap.get(id));
    }
    
    public void addActivity(int id, String str){
        activities.add(new Activity(LocalDateTime.now(), id, str));
        
    }
    
    
    
    
}
