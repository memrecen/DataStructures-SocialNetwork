package View;

import Controller.UsersController;
import java.util.Scanner;

public class RegisterPage {
    
    UsersController uc = new UsersController();
    MenuPage menup = new MenuPage();

    public void getRegisterPage(){
        Scanner keyb = new Scanner(System.in);
        
        while(true){
            System.out.print("\nName: ");
            
            String name = keyb.nextLine();
            
            if(name.isEmpty()){
                System.out.println("\nName can not be empty. Please try again!");
                continue;
            }
            
            System.out.print("ID: ");
            String IDstr = keyb.nextLine();
            
            try {
                int ID = Integer.parseInt(IDstr);
                if (ID <= 0) {
                    System.out.println("\nID must be a positive number.");
                    continue;
                }
                if (UsersController.userMap.containsKey(ID)) {
                    System.out.println("\nUser with ID " + ID + " already exists.");
                    continue;
                }
                uc.addUser(ID, name);
                uc.addActivity(ID,ID+" - "+UsersController.userMap.get(ID).getName()+" has registered.");
                return;
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid ID. Please enter a numeric value.");
                continue;
                
            }
        }
    }
    
     
}
