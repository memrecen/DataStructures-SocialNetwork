package Main;

import Controller.UsersController;
import View.MenuPage;

public class Main {

    public static void main(String[] args) {
        
        UsersController uc = new UsersController();
        
        uc.addUser(1, "AAAAA");
        uc.addUser(2, "BBBBB");
        uc.addUser(3, "CCCCC");
        uc.addUser(4, "DDDDD");
        uc.addUser(5, "EEEEE");
        uc.addUser(6, "GGGGG");
        
        UsersController.friendshipGraph.get(UsersController.userMap.get(1)).add(UsersController.userMap.get(2));
        UsersController.friendshipGraph.get(UsersController.userMap.get(1)).add(UsersController.userMap.get(3));
        UsersController.friendshipGraph.get(UsersController.userMap.get(1)).add(UsersController.userMap.get(4));
//        UsersController.friendshipGraph.get(UsersController.userMap.get(1)).add(UsersController.userMap.get(5));
        UsersController.friendshipGraph.get(UsersController.userMap.get(1)).add(UsersController.userMap.get(6));
        
        UsersController.friendshipGraph.get(UsersController.userMap.get(2)).add(UsersController.userMap.get(1));
        UsersController.friendshipGraph.get(UsersController.userMap.get(2)).add(UsersController.userMap.get(3));
        UsersController.friendshipGraph.get(UsersController.userMap.get(2)).add(UsersController.userMap.get(4));
        UsersController.friendshipGraph.get(UsersController.userMap.get(2)).add(UsersController.userMap.get(5));
        UsersController.friendshipGraph.get(UsersController.userMap.get(2)).add(UsersController.userMap.get(6));
        
        UsersController.friendshipGraph.get(UsersController.userMap.get(3)).add(UsersController.userMap.get(1));
        UsersController.friendshipGraph.get(UsersController.userMap.get(3)).add(UsersController.userMap.get(2));
        UsersController.friendshipGraph.get(UsersController.userMap.get(3)).add(UsersController.userMap.get(4));
        UsersController.friendshipGraph.get(UsersController.userMap.get(3)).add(UsersController.userMap.get(5));
        UsersController.friendshipGraph.get(UsersController.userMap.get(3)).add(UsersController.userMap.get(6));
        
        UsersController.friendshipGraph.get(UsersController.userMap.get(4)).add(UsersController.userMap.get(1));
        UsersController.friendshipGraph.get(UsersController.userMap.get(4)).add(UsersController.userMap.get(2));
        UsersController.friendshipGraph.get(UsersController.userMap.get(4)).add(UsersController.userMap.get(3));
        UsersController.friendshipGraph.get(UsersController.userMap.get(4)).add(UsersController.userMap.get(5));
//        UsersController.friendshipGraph.get(UsersController.userMap.get(4)).add(UsersController.userMap.get(6));
        
//        UsersController.friendshipGraph.get(UsersController.userMap.get(5)).add(UsersController.userMap.get(1));
        UsersController.friendshipGraph.get(UsersController.userMap.get(5)).add(UsersController.userMap.get(2));
        UsersController.friendshipGraph.get(UsersController.userMap.get(5)).add(UsersController.userMap.get(3));
        UsersController.friendshipGraph.get(UsersController.userMap.get(5)).add(UsersController.userMap.get(4));
//        UsersController.friendshipGraph.get(UsersController.userMap.get(5)).add(UsersController.userMap.get(6));

        UsersController.friendshipGraph.get(UsersController.userMap.get(6)).add(UsersController.userMap.get(1));
        UsersController.friendshipGraph.get(UsersController.userMap.get(6)).add(UsersController.userMap.get(2));
        UsersController.friendshipGraph.get(UsersController.userMap.get(6)).add(UsersController.userMap.get(3));
//        UsersController.friendshipGraph.get(UsersController.userMap.get(6)).add(UsersController.userMap.get(4));
//        UsersController.friendshipGraph.get(UsersController.userMap.get(6)).add(UsersController.userMap.get(5));
        
        
        MenuPage menup = new MenuPage();
        System.out.println("Welcome to Social Network !");
        menup.getMenuPage();
        
        
    }
    
}
/*
        
*/
