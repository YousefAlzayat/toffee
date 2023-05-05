import jdk.jfr.Category;
import java.util.Objects;
import java.util.Scanner;
import static java.lang.System.exit;//to use exit(0) in switch to end switch statement
public class Item {
    private String name;
    private String description = "";
    private int price = 0;
    private int availableAmount;
    private String brand;
    private int discountAmount;
    private String categoryName;
    public static  int increaseAmountSold = 0;
    private Admin admin;

    public Item() {
        this.name = "";
        this.price = 0;
        this.description = "";
        this.availableAmount = 0;
        this.brand = "";
        this.discountAmount = 0;
        this.categoryName = "";
        this.admin = null;
    }

    public Item(String name, int price, String des, int amount, String bName, int discount, String CName, Admin a) {
        this.name = name;
        this.price = price;
        this.description = des;
        this.availableAmount = amount;
        this.brand = bName;
        this.discountAmount = discount;
        this.categoryName = CName;
        this.admin = a;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    private String IconPath;
    Scanner in = new Scanner(System.in);
    public void setBrandIcon(Admin admin){
        System.out.println("Please enter the icon path: ");
        this.IconPath = in.next();
    }
    public void setName(Admin a){
        System.out.println("please enter the name of Item");
        this.name = in.next();
    }
    public String getName(){
        return name;
    }
    public void setDescription(Admin admin){
        System.out.println("Please enter the description: ");
        System.out.println("-enter '\n' to end entering process-");
        String n;
        n = in.next();
        while(!Objects.equals(n, "\n")){
            this.description += n;
        }

    }
    public String getDescription() {
        return description;
    }
    public void setPrice(Admin a){
        System.out.println("Please enter price: ");
        this.price = in.nextInt();
    }
    public int getPrice(){
        return price;
    }
    public void setAvailableAmount(Admin a){
        System.out.println("Please enter the available amount: ");
        this.availableAmount = in.nextInt();
    }
    public int getAvailableAmount(){
        return availableAmount;
    }
    public boolean bestSeller(){
        if(increaseAmountSold > 100){
            return true;
        }
        return false;
    }
    public void setBrandName(Admin a){
        System.out.println("please enter the brand name: ");
        this.brand = in.next();
    }
    public String getBrandName(){
        return brand;
    }
    public void setDiscountAmount(Admin a){
        System.out.println("Please enter discount amount: ");
        this.discountAmount = in.nextInt();
    }
    public int getDiscountAmount(){
        return discountAmount;
    }
    public void setCategoryName(Admin a){
        System.out.println("Please enter category name: ");
        this.categoryName = in.next();
    }
    public String getCategoryName(){
        return categoryName;
    }
    public void updateItemInfo(Admin a) {
        int choice = 0;
        do {
            System.out.println("Properties of the item: \n" +
                    "1.Name.\n" +
                    "2.Description.\n" +
                    "3.Price.\n" +
                    "4.Available Amount.\n" +
                    "5.Category Name.\n" +
                    "6.Brand Name.\n" +
                    "7.Brand Icon Path.\n" +
                    "8.Exit.");
            System.out.println("Please enter number of property you want to update: ");
            choice = in.nextInt();
            switch (choice) {
                default -> System.out.println("Invalid choice, Try again.");
                case 1 ->
                    setName(a);
                case 2 -> setDescription(a);
                case 3 -> setPrice(a);
                case 4 -> setAvailableAmount(a);
                case 5 -> setCategoryName(a);
                case 6 -> setBrandName(a);
                case 7 -> setBrandIcon(a);
                case 8 -> {
                    System.out.println("EXIT...");
                    exit(0);
                }
            }

        }while (true);
    }


}
