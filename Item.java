// import jdk.jfr.Category;
// import java.util.Objects;
import java.util.Scanner;
public class Item {
    private String name;
    private String description = "";
    private int price = 0;
    private int availableAmount;
    private String brand;
    private String discountAmount;
    private String categoryName;
    public static  int increaseAmountSold = 0;
    public Item() {
        this.name = "";
        this.price = 0;
        this.description = "";
        this.availableAmount = 0;
        this.brand = "";
        this.discountAmount = "";
        this.categoryName = "";
    }

    public Item(String name, int price, String des, int amount, String bName, String discount, String CName) {
        this.name = name;
        this.price = price;
        this.description = des;
        this.availableAmount = amount;
        this.brand = bName;
        this.discountAmount = discount;
        this.categoryName = CName;
    }

    private String IconPath;

    Scanner in = new Scanner(System.in);
    public void setBrandIcon(){
        System.out.print("Please enter the icon path: ");
        this.IconPath = in.next();
    }
    public void setName(){
        System.out.print("please enter the name of Item: ");
        this.name = in.next();
        in.nextLine();
    }
    public String getName(){
        return name;
    }
    public void setDescription(){
        System.out.println("Please enter the description: ");
        this.description = in.nextLine();
    }
    public String getDescription() {
        return description;
    }
    public void setPrice(){
        System.out.print("Please enter price: ");
        this.price = in.nextInt();
    }
    public int getPrice(){
        return this.price;
    }
    public void setAvailableAmount(int amount){
        this.availableAmount = amount;
    }
    public int getAvailableAmount(){
        return this.availableAmount;
    }
    public boolean bestSeller(){
        if(increaseAmountSold > 100){
            return true;
        }
        return false;
    }
    public void setBrandName(){
        System.out.print("please enter the brand name: ");
        this.brand = in.next();
    }
    public String getBrandName() {
        return this.brand;
    }
    public void setDiscountAmount(){
        System.out.print("Please enter discount amount: ");
        this.discountAmount = in.nextLine();
        in.nextLine();
    }
    public String getDiscountAmount(){
        return discountAmount;
    }
    public void setCategoryName(String CName){
        this.categoryName = CName;
    }
    public String getCategoryName(){
        return categoryName;
    }
     public boolean AvailableORNot(){
         if(availableAmount == 0){
             return false;
         }
         return true;
     }
}
