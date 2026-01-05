package View;

import Controller.UsersController;
import java.util.ArrayList;
import java.util.Scanner;

public class FindMutualFPage {
    
    Scanner keyb = new Scanner(System.in);
    UsersController uc = new UsersController();
    
    public void getFindMutualFPage(){
        
        while(true){
            System.out.print("\nEnter the user id that you want to find mutual friends(Enter 0 to back): ");
            String str = keyb.nextLine();
            try{
                int fid = Integer.parseInt(str);
            }catch(NumberFormatException ex){
                System.out.println("\nEnter a valid ID!");
                continue;
            }
            int fid = Integer.parseInt(str);
            if(fid==0){
                System.out.println("\nBacking...");
                return;
            }
            if(fid == UsersController.uid){
                System.out.println("\nYou can not enter your ID!");
                continue;
            }
            if(fid<=0 || fid>UsersController.userMap.size()){
                System.out.println("\nEnter a valid ID!");
                continue;
            }
            if(!UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid)).contains(UsersController.userMap.get(fid))){
                System.out.println("\nYou are not friend with this user!");
                continue;
            }
            ArrayList<Integer> mfList = new ArrayList<>();
            
            for (int i = 0; i < UsersController.friendshipGraph.get(UsersController.userMap.get(fid)).size(); i++) {
                for (int j = 0; j < UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid)).size(); j++) {
                    if(UsersController.friendshipGraph.get(UsersController.userMap.get(fid)).get(i) == UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid)).get(j)){
                        int mfid = UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid)).get(j).getID();
                        mfList.add(mfid);
                    }
                }
            }
            uc.addActivity(UsersController.uid,UsersController.uid+" - "+UsersController.userMap.get(UsersController.uid).getName()+
                        " found mutual friends with "+fid+" - "+UsersController.userMap.get(fid).getName());
            if(mfList.isEmpty()){
                System.out.println("\nNo mutual friends.");
                break;
            }else{
                System.out.println("\nMutual Friends:");
                for (int i = 0; i < mfList.size(); i++) {
                    int mfid = mfList.get(i);
                    System.out.println(mfid+" - "+UsersController.userMap.get(mfid).getName());
                }
                break;
            }
        }
    }
}
