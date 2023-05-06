import java.util.Objects;
import java.util.Vector;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.in;

public class Toffee {

    private  Vector<Account> accounts = new Vector<>();
    private  Vector<Category> categories = new Vector<>();
    private String tempOTP = "";
    public Toffee(Vector<Account> accounts, Vector<Category> categories) {
        this.accounts = accounts;
        this.categories = categories;
    }

    public Toffee(){}
    public void displayCategories(){
        System.out.print("{ ");
        for(int i = 0; i < categories.size(); i++){
            System.out.print(categories.get(i) + " ");
        }
        System.out.println("}");
    }

    public int foundedMail(String mail){
        for(int i = 0; i < accounts.size(); i++){
            if(Objects.equals(accounts.get(i).getMail(), mail)){
                return i;
            }
        }
        return -1;
    }
    public String correctPassword(String pass){
        for(int i = 0; i < accounts.size(); i++){
            if(Objects.equals(accounts.get(i).getPassword(), pass)){
                return accounts.get(i).getPassword();
            }
        }
        return "Incorrect Password";
    }

    public void displaySystem() {
        Scanner reader = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("-=-=-=-=-=-=-=-=-");
            System.out.println("Welcome to Toffee!");
            System.out.println("Please enter what you would like to do from the following: ");
            System.out.println("(1) Register");
            System.out.println("(2) Login");
            System.out.println("(3) View Catalogue");
            System.out.println("(4) Exit");
            System.out.print("Choice: ");
            choice = reader.nextInt();
            System.out.print("\033[H\033[2J");
            switch (choice) {
                default -> System.out.println("Invalid Input, Try Again");
                case 1 -> {
                    Register r = new Register();
                    Account a = new Account();
                    r.createAccount(a);
                    if(foundedMail(a.getMail()) != -1 && accounts.size() != 0){
                        System.out.println("This Mail Is Repeated, Each Mail Has Only One Account. Try Again!");
                    }else {
                        System.out.println("Successfully Created Account.");
                        accounts.add(a);
                        System.out.println(a.getFName() + " " + a.getSName());
//                    System.out.println(a.getLoyalityPoints());
                        displayCategories();
                    }
                }
                case 2 -> {
                    LogIn l = new LogIn();
                    int ch = foundedMail(l.enterMail());
                    while(ch == -1){
                        System.out.println("InValid Mail.");
                        ch = foundedMail(l.enterMail());
                        if(ch == -1){
                            System.out.println("Did you want to register instead of logIn?\n1. YES.\n2. NO.");
                            int d = reader.nextInt();
                            if(d == 1){
                                displaySystem();
                                break;
                            }
                        }
                    }
                    if(Objects.equals(correctPassword(l.enterPassword()), accounts.get(ch).getPassword())){
                        System.out.println("Valid Info ^^");
                        System.out.print(accounts.get(ch).getFName() + " " + accounts.get(ch).getSName());
//                        System.out.println(accounts.get(ch).getLoyalityPoints());
                        displayCategories();
                    }else{
                        while(true){
                            System.out.println("This is wrong password for this mail");
                            System.out.print("You can:\n1. Enter Password Again.\n2. Update Password.\nEnter your choice: ");
                            int n = reader.nextInt();
                            if(n == 1){
                               String newPass = l.enterPassword();
                               if(Objects.equals(correctPassword(newPass), accounts.get(ch).getPassword())){
                                   System.out.print(accounts.get(ch).getFName() + " " + accounts.get(ch).getSName());
//                                 System.out.println(accounts.get(ch).getLoyalityPoints());
                                   displayCategories();
                                   break;
                               }
                            }else if(n == 2){
                                accounts.get(ch).updatePassword(l.forgetPassword());
                                System.out.println("Valid Info ^^");
                                System.out.println(accounts.get(ch).getFName() + " " + accounts.get(ch).getSName());
//                                 System.out.println(accounts.get(ch).getLoyalityPoints());
                                displayCategories();
                                break;
                            }else{
                                System.out.println("Try Again....");
                            }
                        }
                    }
                }
                case 3 -> displayCategories();
                case 4 -> {
                    System.out.println("Thank you for using Toffee, have a nice day!");
                    System.out.println("Exiting...");
                    exit(0);
                }
            }
        } while (true);

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
    public void displayAccounts(){
        for(int i = 0; i < accounts.size(); i++){
            System.out.println(accounts.get(i));
        }
    }
}

