package View;

import Controller.UsersController;
import Model.Post;
import Model.Users;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewFeedPage {
    
    Scanner keyb = new Scanner(System.in);
    UsersController uc = new UsersController();
    
    public void getViewFeedPage(){
        
        while(true){
            System.out.println("\n1. Your Posts");
            System.out.println("2. Your Friends' Post");
            System.out.println("0. Back");
            System.out.print("Enter a command: ");
            String str = keyb.nextLine();
            
            switch (str) {
                case "1":
                    yourP();
                    break;
                case "2":
                    friendsP();
                    break;
                case "0":
                    System.out.println("\nBacking...");
                    return;
                default:
                    System.out.println("\nPlease enter a valid number!");
                    break;
            }
        }
    }
    
    public void yourP(){
        boolean isThere = false;
        for (Post post:UsersController.posts) {
            if(UsersController.uid == post.getUserID()){
                isThere= true;
            }
        }
        if(!isThere){
            System.out.println("\nYou dont have any post.");
            return;
        }
        while(true){
            int i = 1;
            ArrayList<Post> list = new ArrayList<>();
            System.out.println("");
            for (Post post:UsersController.posts) {
                if(post.getUserID() == UsersController.uid){
                    System.out.println("("+(i++)+") "+post.getPostDate()+" - "+post.getUserID()+" - "+post.getName()+": "+post.getContant());
                    list.add(post);
                }
            }
            System.out.print("Select the post that you want to delete(Enter 0 to back):");
            String str = keyb.nextLine();
            try{
                int n = Integer.parseInt(str);
            }catch(NumberFormatException ex){
                System.out.println("\nEnter a valid number!");
                continue;
            }
            int n = Integer.parseInt(str);
            if(n==0){
                System.out.println("\nBacking...");
                return;
            }
            if(n<0 || n>list.size()){
                System.out.println("\nEnter a valid number!");
                continue;
            }
            Post selPost = list.get(n-1);
            System.out.println("\nAre you sure to delete selected post: "+selPost.getPostDate()+" - "+selPost.getUserID()+" - "+selPost.getName()+" - "+selPost.getContant());
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter a command: ");
            String str1 = keyb.nextLine();
            switch (str1) {
                case "1":
                    UsersController.posts.remove(selPost);
                    uc.addActivity(UsersController.uid,UsersController.uid+" - "+UsersController.userMap.get(UsersController.uid).getName()+
                        " deleted the post: "+selPost.getPostDate()+" - "+selPost.getName()+" - "+selPost.getContant());
                    System.out.println("\nThe post has been deleted!");
                    continue;
                case "2":
                    continue;
                default:
                    System.out.println("\nEnter a valid number!");
                    break;
            }
        }
    }
    
    public void friendsP(){
        uc.addActivity(UsersController.uid,UsersController.uid+" - "+UsersController.userMap.get(UsersController.uid).getName()+
                        " viewed the friends posts.");
        if(UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid)).isEmpty()){
            System.out.println("\nYou have no friends.");
            return;
        }
        boolean isThere = false;
        for (Users user : UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid))) {
            int fid = user.getID();
            for (Post post :UsersController.posts) {
                if(post.getUserID()==fid){
                    isThere = true;
                }
            }
        }
        if(!isThere){
            System.out.println("\nNo post.");
            return;
        }
        System.out.println("\n------------------------------------------");
        System.out.println("Posts;");
        for (Post post:UsersController.posts) {
            for (Users user : UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid))) {
                int fid = user.getID();
                if(post.getUserID()==fid){
                    System.out.println("\n"+post.getPostDate()+" - "+post.getUserID()+" - "+post.getName()+": "+post.getContant());
                }
            }
        }
        System.out.println("------------------------------------------");
        return;
        
        
        
    }
    
    
    
    
    
    
    
}
