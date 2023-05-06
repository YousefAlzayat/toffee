import java.util.ArrayList;
import java.util.Scanner;

public class Toffee {
    
    private ArrayList<Account> accounts;
    private ArrayList<Category> categories;
    private String tempOTP = "";

    public void displaySystem(){
        Scanner reader = new Scanner(System.in);
        System.out.println("-=-=-=-=-=-=-=-=-");
        System.out.println("Welcome to Toffee!");
        System.out.println("Please enter what you would like to do from the following: ");
        System.out.println("(1) Register");
        System.out.println("(2) Login");
        System.out.println("(3) View Catalogue");
        System.out.println("(4) Exit");
        System.out.print("Choice: ");
        int choice = reader.nextInt();

        System.out.print("\033[H\033[2J"); 
        switch(choice){
            case 1:
                System.out.println("You chose the register option");
                break;

            case 2:
                System.out.println("You chose the LogIn option");
                break;
                
            case 3:
                displayCategories();
                break;

                default:
                System.out.println("Thank you for using Toffee, have a nice day!");
                System.out.println("Exiting...");
                break;
        }

        reader.close();


    }

    public void displayCategories(){

    }

    public String createOTP(){
        Integer otp = (int) Math.floor(Math.random() * (9999 - 1000 + 1) + 1000);
        tempOTP = otp.toString();

        return tempOTP;
    }

    public boolean correctOTP(String s){
        if(s == tempOTP) {
            tempOTP = "";
            return true;
        } 
        return false;
    }

    public void sentOTP(Account account){
        System.out.println("\nFrom: " + "system@toffee.com");
        System.out.println("To: " + account.getMail());
        System.out.println("Subject: " + "OTP Request");
        System.out.println("Body: ");
        System.out.println("\nPlease enter this number in the program: " + tempOTP + "\n");
    }

}
