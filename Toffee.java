import java.util.Objects;
import java.util.Vector;
import java.util.Scanner;
import java.util.regex.*;
import static java.lang.System.exit;

public class Toffee {

    Scanner reader = new Scanner(System.in);

    protected Vector<Account> accounts = new Vector<>();
    protected Vector<Category> categories = new Vector<>();
    private Account loggedAccount;
    private String tempOTP = "";

    public Toffee(){}

    public Toffee(Vector<Account> accounts, Vector<Category> categories) {
        this.accounts = accounts;
        this.categories = categories;
    }

    public void displayCart(){
        int choice2=-1;
        while(true){
            //System.out.print("\033[H\033[2J");

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
                //System.out.print("\033[H\033[2J");


                System.out.println("How would you like to pay for the order?");
                System.out.println("(1) Pay on delivery");
                System.out.println("(2) Pay with Visa - Coming soon");
                System.out.println("(3) Pay with eWallet - Coming soon");
                System.out.println();
                System.out.print("Choice: ");

                String temp2 = reader.nextLine();
                if(temp2.equals("1")) {
                    loggedAccount.cart.payment = new CashOnDelivery();
                    loggedAccount.cart.payment.functionality();
                    // exit(0);
                    break;
                }
            }

            loggedAccount.makeOrder();

            return;
        }
    }

    public void displayCategories(){
        String temp = "";

        // OFFER CATEGORY EXPLORATION OPTIONS
        while(true){

            //System.out.print("\033[H\033[2J");

            System.out.println("Please enter the category you would like to explore of the following: ");

            for (int i = 0; i < categories.size(); i++) {
                System.out.println("(" + (i+1) + ")" + " " + categories.get(i).getName());
            }

            if(loggedAccount != null) System.out.println("(" + (categories.size()+1) + ") Log Out");
            else System.out.println("(" + (categories.size()+1) + ") Go Back");

            if(loggedAccount != null) System.out.println("(" + (categories.size()+2) + ") Display Cart");

            System.out.print("\nChoice: ");

            temp = reader.nextLine();

            if(Pattern.matches("[1-9]+", temp) && 
                (Integer.parseInt(temp) == categories.size()+1) && loggedAccount != null) loggedAccount = null;

            if(Pattern.matches("[1-9]+", temp) && 
                (Integer.parseInt(temp) <= categories.size()+1) || 
                    (Integer.parseInt(temp) == categories.size()+2 && loggedAccount != null)) break;

        }

        int choice = Integer.parseInt(temp);

        // IF CHOSE TO EXIT OR GO BACK
        if(choice == categories.size()+1) return;

        // DISPLAY CART OPTION
        else if(choice == categories.size()+2) displayCart();
        
        // DISPLAY SPECIFIC CATEGORY OPTION
        else{

            while(true){

                //System.out.print("\033[H\033[2J");


                categories.get(choice-1).displayItems();

                System.out.println("What would you like to do?");

                if(loggedAccount != null)System.out.println("(1" + "-" + categories.get(choice-1).items.size() + ") Add item to cart");
                else System.out.println("(1" + "-" + categories.get(choice-1).items.size() + ") Add item to cart (Please register or log in)");

                System.out.println("( " + (categories.get(choice-1).items.size()+1) + " ) Go back\n");

                System.out.print("Choice: ");

                temp = reader.nextLine();

                if(Pattern.matches("[1-9]+", temp) && 
                    ((loggedAccount != null && Integer.parseInt(temp) < categories.get(choice-1).items.size()+1 && Integer.parseInt(temp) > 0) 
                        || Integer.parseInt(temp) == categories.get(choice-1).items.size()+1))break;
                
            }

            // ADD TO CART OPTION
            if(Integer.parseInt(temp) != categories.get(choice-1).items.size()+1) {

                System.out.print("Enter amount you want to add to cart: ");

                String temp2 = reader.nextLine();

                while(true){

                    int availableAmount = categories.get(choice-1).items.get(Integer.parseInt(temp)-1).getAvailableAmount();


                    if(Pattern.matches("[1-9]+", temp2) && Integer.parseInt(temp2) <= availableAmount){
                            
                        categories.get(choice-1).items.get(Integer.parseInt(temp)-1).setAvailableAmount(availableAmount-Integer.parseInt(temp2));
                        loggedAccount.addToCart(categories.get(choice-1).items.get(Integer.parseInt(temp)-1), Integer.parseInt(temp2));
                        break;

                    }

                    else{
                        if(categories.get(choice-1).items.get(Integer.parseInt(temp)-1).getAvailableAmount() == 0) System.out.println("Item out of stock, press enter to return...");
                        else System.out.print("OUT OF SCOPE AMOUNT!!/nEnter amount you want to add to cart:");

                        temp2 = reader.nextLine();
                        break;
                    }
                }
            }

            displayCategories();
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
        }
        else {

            System.out.println("Please wait...");

            createOTP();
            sendOTP(a);

            while(true){

                System.out.println("An OTP has been sent to your email, please enter the OTP\n");
                System.out.print("OTP: ");

                String nput;
                nput = reader.nextLine();

                if(correctOTP(nput)) break;
                else{
                    System.out.println("\nThe OTP you entered is incorrect. Please try again\n\n");
                }
               
            }

            System.out.println("Successfully Created Account.");

            accounts.add(a);
            loggedAccount = a;

            displayCategories();
        }
    }

    public void displayLogIn(){
        LogIn l = new LogIn();

        int ch = foundedMail(l.enterMail());

        while(ch == -1){

            System.out.println("Invalid Mail.");

            ch = foundedMail(l.enterMail());

            if(ch == -1){
                System.out.println("Did you want to register instead of logIn?\n(1) YES\n(2) NO\n");

                System.out.print("Choice: ");
                int d = reader.nextInt();
                reader.nextLine();
                
                if(d == 1) break;
            }
        }
        if(Objects.equals(correctPassword(l.enterPassword()), accounts.get(ch).getPassword())){
            System.out.println("\033[H\033[2J");

            System.out.println("Valid Info ^^");
            System.out.print("Welcome back ya ");
            System.out.println(accounts.get(ch).getFName() + " " + accounts.get(ch).getSName() + "!");

            loggedAccount = accounts.get(ch);
        }
        else{
            while(true){

                System.out.println("This password is incorrect.");

                System.out.print("You can:\n(1) Enter Password Again.\n(2) Update Password.\nEnter your choice: ");
                int n = reader.nextInt();
                reader.nextLine();

                if(n == 1){
                    String newPass = l.enterPassword();
                    if(Objects.equals(correctPassword(newPass), accounts.get(ch).getPassword())){
                        loggedAccount = accounts.get(ch);
                        break;
                    }
                }
                else if(n == 2){
                    System.out.println("Please wait...");
                    createOTP();
                    sendOTP(accounts.get(ch));

                    while(true){

                        System.out.println("An OTP has been sent to your email, please enter the OTP");
                        System.out.println();
                        System.out.print("OTP: ");

                        String nput;
                        nput = reader.nextLine();

                        if(correctOTP(nput)) break;
                        else{
                            System.out.println();
                            System.out.println("The OTP you entered is incorrect. Please try again");
                            System.out.println();
                            System.out.println();
                        }
                    }

                    accounts.get(ch).updatePassword(l.forgetPassword());

                    System.out.println("Valid Info ^^");

                    loggedAccount = accounts.get(ch);
                    break;
                }
                else{
                    System.out.println("Try Again....");
                }
            }
        }
        displayCategories();
    }

    public void displaySystem() {
        System.out.println("     Welcome to Toffee!     ");
        System.out.println("-=-=-=-=-=-=-==-=-=-=-=-=-=-");

        do {
            String temp = "";

            System.out.println("Please enter what you would like to do from the following: ");

            System.out.println("(1) Register");
            System.out.println("(2) Login");
            System.out.println("(3) View Catalogue");
            System.out.println("(4) Exit");

            System.out.print("\nChoice: ");
            
            temp = reader.nextLine();

            if(!Pattern.matches("[1-4]+", temp)) temp = "5";

            int choice = Integer.parseInt(temp);

            switch (choice) {
                default -> System.out.println("Invalid Input, Try Again");
                case 1 -> {displayRegister();}
                case 2 -> {displayLogIn();}
                case 3 -> {displayCategories();}
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
        if(s.equals(tempOTP)) {
            tempOTP = "";
            return true;
        }
        return false;
    }
    
    public void sendOTP(Account account){
        SendEmail mailer = new SendEmail();
        mailer.send(account.getMail(), tempOTP);
    }

    public void displayAccounts(){
        for(int i = 0; i < accounts.size(); i++){
            System.out.println(accounts.get(i));
        }
    }
}
