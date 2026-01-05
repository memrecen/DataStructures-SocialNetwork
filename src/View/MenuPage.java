package View;

import java.util.Scanner;

public class MenuPage {
    
    public void getMenuPage(){
        
        Scanner keyb = new Scanner(System.in);
        LoginPage lp = new LoginPage();
        RegisterPage rp = new RegisterPage();
        
        
        while(true){
            
            System.out.println("\n1. Log in.");
            System.out.println("2. Register.");
            System.out.println("0. Exit.");
            System.out.print("Please select the operation you want to perform:");
            String str = keyb.nextLine();
            
            switch (str) {
                case "1":
                    lp.getLoginPage();
                    break;
                case "2":
                    rp.getRegisterPage();
                    break;
                case "0":
                    System.out.println("\nExciting...");
                    return;
                default:
                    System.out.println("\nPlease enter a valid number.");
                    break;
            }
        }
    }
    
    
    
}
