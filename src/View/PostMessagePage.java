package View;

import Controller.UsersController;
import Model.Post;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Scanner;

public class PostMessagePage {
    
    Scanner keyb = new Scanner(System.in);
    UsersController uc = new UsersController();
    
    public void getPostMessagePage(){
        
        System.out.print("\nYour new post(Enter 0 to back): ");
        String post1 = keyb.nextLine();
        if(post1.equals("0") || post1.isEmpty()){
            System.out.println("\nBacking...");
            return;
        }
        int uid = UsersController.uid;
        String name = UsersController.userMap.get(uid).getName();
        Post post2 = new Post(uid,name,post1,LocalDateTime.now());
        UsersController.posts.add(post2);
        UsersController.posts.sort(Comparator.comparing((Post post) -> post.postDate).reversed());
        uc.addActivity(UsersController.uid,UsersController.uid+" - "+UsersController.userMap.get(UsersController.uid).getName()+
                        " created a new post: "+post2.getPostDate()+" - "+post2.getName()+" - "+post2.getContant());
        System.out.println("\nThe post was created successfully.");
        return;
    }
    
 }
