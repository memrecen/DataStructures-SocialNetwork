package View;

import Controller.UsersController;
import java.util.Scanner;

public class FriendsPage {
    
    Scanner keyb = new Scanner(System.in);
    UsersController uc = new UsersController();
    
    public void getFriendsPage(){
        
        while(true){
            
            System.out.println("\n1. Friends list.");
            System.out.println("2. Send a friend request");
            System.out.println("3. Show friend requests.");
            System.out.println("0. Back");
            System.out.print("Enter a command: ");
            String str = keyb.nextLine();
            
            switch (str) {
                case "1":
                    friendList();
                    break;
                case "2":
                    sendF();
                    break;
                case "3":
                    requestF();
                    break;
                case "0":
                    System.out.println("\nGoing back...");
                    return;
                default:
                    System.out.println("\nEnter a valid number!");
                    break;
            }
        }
        
    }
    
    public void friendList(){
        while(true){
            System.out.println("\nFriend List:");
            if(UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid)).isEmpty()){
                System.out.println("\nYou have no friends.");
                return;
            }
            
            for (int i = 0; i < UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid)).size(); i++) {
                int fid = UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid)).get(i).getID();
                System.out.println("("+(i+1)+") "+fid+" - "+UsersController.userMap.get(fid).getName());
            }
            System.out.print("Select the friend you want to delete(Enter 0 to back):");
            String str = keyb.nextLine();
            try{
                int n = Integer.parseInt(str);
            }catch(NumberFormatException ex){
                System.out.println("\nEnter a valid number!");
                continue;
            }
            int n = Integer.parseInt(str);
            if(n<0 || n>(UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid)).size())){
                System.out.println("\nEnter a valid number!");
                continue;
            }
            if(n==0){
                return;
            }
            int fid =UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid)).get(n-1).getID();
            System.out.println("\nAre you sure to delete your friend "+UsersController.userMap.get(fid).getName());
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter a command: ");
            String str1 = keyb.nextLine();
            
            switch (str1) {
                case "1":
                    UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid)).remove(UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid)).indexOf(UsersController.userMap.get(fid)));
                    UsersController.friendshipGraph.get(UsersController.userMap.get(fid)).remove(UsersController.friendshipGraph.get(UsersController.userMap.get(fid)).indexOf(UsersController.userMap.get(UsersController.uid)));
                    uc.addActivity(UsersController.uid,UsersController.uid+" - "+UsersController.userMap.get(UsersController.uid).getName()+
                            " defriend "+fid+" - "+UsersController.userMap.get(fid).getName());
                    System.out.println("\nThe friend has been deleted!");
                    continue;
                case "2":
                    continue;
                default:
                    System.out.println("\nEnter a valid number!");
                    break;
            }
        }
        
    }
    
    public void sendF(){
        while(true){
            System.out.print("\nEnter the user ID that you want to send friend request(Enter 0 to back): ");
            String str = keyb.nextLine();
            try{
                int fid = Integer.parseInt(str);
            }catch(NumberFormatException ex){
                System.out.println("\nEnter a valid ID!");
                continue;
            }
            int fid = Integer.parseInt(str);
            
            if(fid==0){
                return;
            }
            if(!UsersController.userMap.containsKey(fid)){
                System.out.println("\nNo user with this ID has been found!");
                continue;
            }
            if(UsersController.friendshipGraph.get(UsersController.userMap.get(fid)).contains(UsersController.userMap.get(UsersController.uid))){
                System.out.println("\nYou're already friends.");
                break;
            }
            if(UsersController.userMap.get(fid).getfRequestList().contains(UsersController.uid)){
                System.out.println("\nYou've already sent a friendrequest.");
                break;
            }
            if(UsersController.uid == fid){
                System.out.println("\nYou can not send a friend request to yourself!");
                continue;
            }
            for(Integer id:UsersController.userMap.keySet()){
                if(id == fid && id != UsersController.uid ){
                    UsersController.userMap.get(fid).getfRequestList().add(UsersController.uid);
                    System.out.println("\nThe friend request was sent to "+UsersController.userMap.get(fid).getName());
                    uc.addActivity(UsersController.uid,UsersController.uid+" - "+UsersController.userMap.get(UsersController.uid).getName()+
                            " sent a friend request to "+fid+" - "+UsersController.userMap.get(fid).getName());
                    return;
                }
            }
        }
    }
    
    public void requestF(){
        if(UsersController.userMap.get(UsersController.uid).getfRequestList().isEmpty()){
            System.out.println("\nThere are no friend requests.");
            return;
        }
        while(true){
            System.out.println("");
            for (int i = 0; i < UsersController.userMap.get(UsersController.uid).getfRequestList().size(); i++) {
                int fid = UsersController.userMap.get(UsersController.uid).getfRequestList().get(i);
                System.out.println("("+(i+1)+") "+fid+" - "+UsersController.userMap.get(fid).getName());
            }
            
            System.out.print("Select a request(Enter 0 to back):");
            String str = keyb.nextLine();
            try{
                int n = Integer.parseInt(str);
            }catch(NumberFormatException ex){
                System.out.println("\nEnter a valid number!");
                continue;
            }
            
            int n = Integer.parseInt(str);
            
            if(n==0){
                return;
            }
            
            if(n<0 || n>(UsersController.userMap.get(UsersController.uid).getfRequestList().size())){
                System.out.println("\nEnter a valid number!");
                continue;
            }
            
            int fid =UsersController.userMap.get(UsersController.uid).getfRequestList().get(n-1);
            System.out.println("\nSelected request: "+fid+" - "+UsersController.userMap.get(fid).getName());
            System.out.println("1. Accept");
            System.out.println("2. Reject");
            System.out.print("Enter a command: ");
            String str1 = keyb.nextLine();
            
            switch (str1) {
                case "1":
                    UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid)).add(UsersController.userMap.get(fid));
                    UsersController.friendshipGraph.get(UsersController.userMap.get(fid)).add(UsersController.userMap.get(UsersController.uid));
                    UsersController.userMap.get(UsersController.uid).getfRequestList().remove(n-1);
                    System.out.println("\nThe friend request has been accepted!");
                    uc.addActivity(UsersController.uid,UsersController.uid+" - "+UsersController.userMap.get(UsersController.uid).getName()+
                            " accepted "+fid+" - "+UsersController.userMap.get(fid).getName()+"'s friend request.");
                    uc.addActivity(UsersController.uid,UsersController.uid+" - "+UsersController.userMap.get(UsersController.uid).getName()+
                            " became friends with "+fid+" - "+UsersController.userMap.get(fid).getName());
                    uc.addActivity(fid,fid+" - "+UsersController.userMap.get(fid).getName()+
                            " became friends with "+UsersController.uid+" - "+UsersController.userMap.get(UsersController.uid).getName());
                    return;
                case "2":
                    UsersController.userMap.get(UsersController.uid).getfRequestList().remove(UsersController.userMap.get(UsersController.uid).getfRequestList().indexOf(UsersController.userMap.get(fid)));
                    System.out.println("\nThe friend request has been rejected!");
                    uc.addActivity(UsersController.uid,UsersController.uid+" - "+UsersController.userMap.get(UsersController.uid).getName()+
                            " rejected "+fid+" - "+UsersController.userMap.get(fid).getName()+"'s friend request.");
                    return;
                default:
                    System.out.println("\nEnter a valid number!");
                    break;
            }
        }
    }
}
