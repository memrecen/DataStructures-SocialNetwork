package View;

import Controller.UsersController;
import java.util.Scanner;

public class LoginPage {
        
    UsersController uc = new UsersController();
    MainPage mp = new MainPage();
    
    public void getLoginPage(){
        
        Scanner keyb = new Scanner(System.in);
        
        while(true){
            
            System.out.print("\nID(Enter 0 to back): ");
            String IDstr = keyb.nextLine();
            try{
                    int ID = Integer.parseInt(IDstr);
                }catch(NumberFormatException ex){
                    System.out.println("\nEnter a valid number!");
                    continue;
                }
            int ID = Integer.parseInt(IDstr);
            if(ID == 0 ){
                System.out.println("\nBacking...");
                return;
            }
            if(UsersController.userMap.isEmpty()){
                System.out.println("\nThe entered ID is not correct!");
                return;
            }
            if(UsersController.userMap.containsKey(ID)){
                System.out.println("\nLog in succesfully: "+UsersController.userMap.get(ID).getName());
                uc.addActivity(ID,ID+" - "+UsersController.userMap.get(ID).getName()+" has logged in.");
                UsersController.uid = ID;
                mp.getMainPage();
                break;
            }else{
                System.out.println("\nThe entered ID is not correct!!!");
                continue;
            }
        }
    }
}
