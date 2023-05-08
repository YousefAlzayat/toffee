import java.util.Objects;
import java.util.Vector;
import java.util.Scanner;
import java.util.regex.*;

// import javax.lang.model.type.NullType;

import static java.lang.System.exit;
// import static java.lang.System.in;

public class Toffee {

    Scanner reader = new Scanner(System.in);

    protected Vector<Account> accounts = new Vector<>();
    protected Vector<Category> categories = new Vector<>();
    private Account loggedAccount;
    private String tempOTP = "";
    public Toffee(Vector<Account> accounts, Vector<Category> categories) {
        this.accounts = accounts;
        this.categories = categories;
    }

    public Toffee(){}

    public void displayCategories(){
        String temp = "";
        while(true){
            System.out.print("\033[H\033[2J");
            System.out.println("Please enter the category you would like to explore of the following: ");

            for (int i = 0; i < categories.size(); i++) {
                System.out.println("(" + (i+1) + ")" + " " + categories.get(i).getName());
            }
            System.out.println("(" + (categories.size()+1) + ") Go back");
            if(loggedAccount != null) System.out.println("(" + (categories.size()+2) + ") Display Cart");
            System.out.println();
            System.out.print("Choice: ");
            temp = reader.nextLine();
            if(Pattern.matches("[1-9]+", temp) && (Integer.parseInt(temp) <= categories.size()+1) || (Integer.parseInt(temp) == categories.size()+2 && loggedAccount != null)) break;
        }

        int choice = Integer.parseInt(temp);

        if(choice == categories.size()+2){
            int choice2=-1;
            while(true){
                System.out.print("\033[H\033[2J");
                loggedAccount.viewCart();
                System.out.println("What do you want to do?");
                System.out.println("(1) Go back");
                if(loggedAccount.cartEmpty()) System.out.println("(2) Go to Checkout - Please add items to the cart first");
                else System.out.println("(2) Go to Checkout");
                System.out.println();
                System.out.print("Choice: ");

                String temp2 = reader.nextLine();
                if(Pattern.matches("[1-2]", temp2) && (!loggedAccount.cartEmpty() || Pattern.matches("[1]", temp2))){
                    choice2 = Integer.parseInt(temp2);
                    break;
                }
            }

            if(choice2==2){
                while(true){
                    System.out.print("\033[H\033[2J");

                    System.out.println("How would you like to pay for the order?");
                    System.out.println("(1) Pay on delivery");
                    System.out.println("(2) Pay with Visa - Coming soon");
                    System.out.println("(3) Pay with eWallet - Coming soon");
                    System.out.println();
                    System.out.print("Choice: ");

                    String temp2 = reader.nextLine();
                    if(temp2.equals("1")) {
                        System.out.println("The order will be paid for upon delivery.");
                        System.out.println("The order will arrive within 3 working days.");
                        System.out.println("Thank you for shopping at Toffee!");
                        // exit(0);
                        break;
                    }
                }

                loggedAccount.makeOrder();

                return;
            }

        }

        else if(choice <= categories.size()) {
            while(true){
                System.out.print("\033[H\033[2J");

                categories.get(choice-1).displayItems();

                System.out.println("What would you like to do?");

                if(loggedAccount != null)System.out.println("(1" + "-" + categories.get(choice-1).items.size() + ") Add item to cart");
                else System.out.println("(1" + "-" + categories.get(choice-1).items.size() + ") Add item to cart (Please register or log in)");
                System.out.println("( " + (categories.get(choice-1).items.size()+1) + " ) Go back" );
                System.out.println();
                System.out.print("Choice: ");

                temp = reader.nextLine();
                if(Pattern.matches("[1-9]+", temp) && ((loggedAccount != null && Integer.parseInt(temp) < categories.get(choice-1).items.size()+1 && Integer.parseInt(temp) > 0) ||
                        Integer.parseInt(temp) == categories.get(choice-1).items.size()+1)) break;
            }

            if(Integer.parseInt(temp) != categories.get(choice-1).items.size()+1) {
                System.out.print("Enter amount you want to add to cart: ");
                String temp2 = reader.nextLine();
                while(true){
                    if(Pattern.matches("[1-9]+", temp2) &&  Integer.parseInt(temp2) <= categories.get(choice-1).items.get(Integer.parseInt(temp)-1).getAvailableAmount()){
                        categories.get(choice-1).items.get(Integer.parseInt(temp)-1).setAvailableAmount(categories.get(choice-1).items.get(Integer.parseInt(temp)-1).getAvailableAmount()-Integer.parseInt(temp2));
                        loggedAccount.addToCart(categories.get(choice-1).items.get(Integer.parseInt(temp)-1), Integer.parseInt(temp2));
                        break;
                    }else{
                        System.out.print("OUT OF SCOPE AMOUNT!!/nEnter amount you want to add to cart:");
                        temp2 = reader.nextLine();
                    }
                }
            }
            displayCategories();
        }
        else{
            return;
        }
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

    public void displayRegister(){
        Register r = new Register();
        Account a = new Account();
        r.createAccount(a);
        if(foundedMail(a.getMail()) != -1 && accounts.size() != 0){
            System.out.println("This Mail Is Repeated, Each Mail Has Only One Account. Try Again!");
        }else {
            System.out.println("Successfully Created Account.");
            accounts.add(a);
            loggedAccount = a;
            System.out.println(a.getFName() + " " + a.getSName());
//                 System.out.println(a.getLoyalityPoints());
            displayCategories();
        }
    }

    public void displayLogIn(){
        // Scanner reader = new Scanner(System.in);
        LogIn l = new LogIn();
        int ch = foundedMail(l.enterMail());
        while(ch == -1){
            System.out.println("Invalid Mail.");
            ch = foundedMail(l.enterMail());
            if(ch == -1){
                System.out.println("Did you want to register instead of logIn?\n1. YES.\n2. NO.");
                System.out.println();
                System.out.println("Choice: ");
                int d = reader.nextInt();
                reader.nextLine();
                if(d == 1){
                    // displaySystem();
                    break;
                }
            }
        }
        if(Objects.equals(correctPassword(l.enterPassword()), accounts.get(ch).getPassword())){
            System.out.println("\033[H\033[2J");
            System.out.println("Valid Info ^^");
            System.out.print("Welcome back ya ");
            System.out.print(accounts.get(ch).getFName() + " " + accounts.get(ch).getSName());
            System.out.println("!");
            loggedAccount = accounts.get(ch);
//                        System.out.println(accounts.get(ch).getLoyalityPoints());
            // displayCategories();
        }else{
            while(true){
                System.out.println("This is wrong password for this mail");
                System.out.print("You can:\n1. Enter Password Again.\n2. Update Password.\nEnter your choice: ");
                int n = reader.nextInt();
                reader.nextLine();
                if(n == 1){
                    String newPass = l.enterPassword();
                    if(Objects.equals(correctPassword(newPass), accounts.get(ch).getPassword())){
                        System.out.print(accounts.get(ch).getFName() + " " + accounts.get(ch).getSName());
                        loggedAccount = accounts.get(ch);
                        break;
                    }
                }else if(n == 2){
                    accounts.get(ch).updatePassword(l.forgetPassword());
                    System.out.println("Valid Info ^^");
                    System.out.println(accounts.get(ch).getFName() + " " + accounts.get(ch).getSName());
                    loggedAccount = accounts.get(ch);
                    break;
                }else{
                    System.out.println("Try Again....");
                }
            }
        }
        displayCategories();
        // reader.close();
    }

    public void displaySystem() {
        if(loggedAccount == null) System.out.println("    Welcome to Toffee!");
        else System.out.println("Welcome to Toffee!");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        int choice = 0;
        do {
            String temp = "";
            /*while(!Pattern.matches("[1-4]", temp)){
                System.out.print("\033[H\033[2J");
                if(loggedAccount != null)System.out.print("Logged In as " + loggedAccount.getFName() + " " + loggedAccount.getSName() + " - ");
                else System.out.print("Not Logged in - ");
                System.out.println("Please enter what you would like to do from the following: ");
                System.out.println("(1) Register");
                System.out.println("(2) Login");
                System.out.println("(3) View Catalogue");
                System.out.println("(4) Exit");
                System.out.println();
                System.out.print("Choice: ");

                temp = reader.nextLine();

            }*/
            System.out.println("Please enter what you would like to do from the following: ");
            System.out.println("(1) Register");
            System.out.println("(2) Login");
            System.out.println("(3) View Catalogue");
            System.out.println("(4) Exit");
            System.out.println();
            System.out.print("Choice: ");
            temp = reader.nextLine();
            choice = Integer.parseInt(temp);

            switch (choice) {
                default -> System.out.println("Invalid Input, Try Again");
                case 1 -> {displayRegister();}
                case 2 -> {displayLogIn();}
                case 3 -> {displayCategories();}
                case 4 -> {
                    // reader.close();
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
    public void sendOTP(Account account){
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
