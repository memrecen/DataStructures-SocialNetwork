package View;

import Controller.UsersController;
import Model.Post;
import Model.Users;
import java.util.Scanner;

public class SearchUserPage {
    
    Scanner keyb = new Scanner(System.in);
    UsersController uc = new UsersController();
    
    public void getSearchUserPage(){
        
        while(true){
            boolean isThere = false;
            System.out.print("\nEnter user ID or name that you want to search(Enter 0 to back): ");
            String str = keyb.nextLine();
            if(str.equalsIgnoreCase("0")){
                System.out.println("\nBacking...");
                return;
            }
            uc.addActivity(UsersController.uid,UsersController.uid+" - "+UsersController.userMap.get(UsersController.uid).getName()+
                        " searched this ID: "+str);
            for (Users user : UsersController.userMap.values()) {
                if(str.equalsIgnoreCase(user.getName()) || str.equalsIgnoreCase(user.getID()+"")){
                    isThere = true;
                    System.out.println("\n"+user.getID()+" - "+user.getName());
                    if(UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid)).contains(user)){
                        System.out.println("Friends with you.");
                    }else{
                        System.out.println("Not friends with you.");
                    }
                    for (Post post : UsersController.posts) {
                        if(post.getUserID()==user.getID()){
                            System.out.println(post.getPostDate()+" - "+post.getUserID()+" - "+post.getName()+": "+post.getContant());
                        }
                    }
                }
            }
            if(!isThere){
                System.out.println("\nThe user has not been found!");
                continue;
            }
            return;
            
        }
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
}
