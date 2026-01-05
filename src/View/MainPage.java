package View;

import Controller.UsersController;
import Model.Activity;
import Model.Users;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class MainPage {
    
    public void getMainPage(){
        
        Scanner keyb = new Scanner(System.in);
        FriendsPage fp = new FriendsPage();
        FindMutualFPage fmp = new FindMutualFPage();
        PostMessagePage pmp = new PostMessagePage();
        ViewFeedPage vfp = new ViewFeedPage();
        SearchUserPage sup = new SearchUserPage();
        UsersController uc = new UsersController();
        
        while (true) {
            System.out.println("\nAvailable Commands:");
            System.out.println("1. friends");
            System.out.println("2. find_mutual_friends");
            System.out.println("3. friend_recommendations");
            System.out.println("4. share_post");
            System.out.println("5. view_feed");
            System.out.println("6. view_activity_feed");
            System.out.println("7. search_user");
            System.out.println("8. remove_account");
            System.out.println("0. log_out");
            System.out.print("Enter a command: ");
            String str = keyb.nextLine();

            switch (str) {
                case "1":
                    fp.getFriendsPage();
                    break;
                case "2":
                    fmp.getFindMutualFPage();
                    break;
                case "3":
                    ArrayList<Users> fr = new ArrayList<>();
                    if(UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid)).isEmpty()){
                        System.out.println("\nNo friend recommendation");
                        break;
                    }
                    for (Users friend : UsersController.friendshipGraph.get(UsersController.userMap.get(UsersController.uid))) {
                        if(!UsersController.friendshipGraph.get(friend).isEmpty()){
                            for (Users user : UsersController.friendshipGraph.get(friend)) {
                                if(user.getID()!=UsersController.uid && !UsersController.friendshipGraph.get(user).contains(UsersController.userMap.get(UsersController.uid))){
                                    fr.add(user);
                                }
                            }
                        }
                    }
                    HashMap<Users, Integer> userCount = new HashMap<>();
                    for (Users user : fr) {
                        userCount.put(user, userCount.getOrDefault(user, 0) + 1);
                    }
                    ArrayList<Users> okay = new ArrayList<>();
                    for (Users user : userCount.keySet()) {
                        if(userCount.get(user)>=2){
                            okay.add(user);
                        }
                    }
                    if(okay.isEmpty()){
                        System.out.println("\nNo friend recommendation");
                        break;
                    }else{
                        System.out.println("\nFriend recommendations:");
                        for (Users user : okay) {
                            System.out.println(user.getID()+" - "+user.getName()+" - You have "+userCount.get(user)+" mutual friends.");
                        }
                        
                    }
                    break;
                case "4":
                    pmp.getPostMessagePage();
                    break;
                case "5":
                    vfp.getViewFeedPage();
                    break;
                case "6":
                    System.out.println("");
                    Stack<Activity> stack = new Stack<>();
                    for (Activity activity : UsersController.activities) {
                        if (activity.getId() == UsersController.uid) {
                            stack.push(activity);
                        }
                    }
                    while(!stack.isEmpty()){
                        Activity activity = stack.pop();
                        System.out.println(activity.getDate()+" - "+activity.getActivty());
                    }
                    uc.addActivity(UsersController.uid,UsersController.uid+" - "+UsersController.userMap.get(UsersController.uid).getName()+
                            " viewed activity feed.");
                    break;
                case "7":
                    sup.getSearchUserPage();
                    break;
                case "8":
                    System.out.println("Are you sure you want to delete your account?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.print("Enter a command: ");
                    String str1 = keyb.nextLine();
                    switch(str1) {
                        case "1":
                            uc.removeUser(UsersController.uid);
                            System.out.println("\nThe account has been successfully deleted!");
                            return;
                        case "2":
                            break;
                        default:
                            System.out.println("\nWrong command, cancel...");
                            break;
                    }
                    break;
                case "0":
                    System.out.println("\nLogging out...");
                    uc.addActivity(UsersController.uid,UsersController.uid+" - "+UsersController.userMap.get(UsersController.uid).getName()+
                            " has logged out.");
                    return;
                default:
                    System.out.println("\nPlease enter a valid number!");
                    break;
            }
        }
        
    }
    
    
    
    
    
}
