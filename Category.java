import java.util.Scanner;
import java.util.Vector;
public class Category {
    private String name;
//    private ArrayList<Item>I;
    private Vector<Item> items = new Vector<>();
    Category(){
        this.name = "";
    }
    Category(String n,Item i){
        this.name = n;
        items.add(i);
    }
    Scanner in = new Scanner(System.in);
    public void setName(String Cname){
        this.name = Cname;
    }
    public String getName(){
        return this.name;
    }
    public void addNewItem(Item item){
        if (items.contains(item)){
            System.out.println("Item is already existing...");
        }else{
            item.setName();
            item.setDescription();
            item.setPrice();
            item.setCategoryName(name);
            item.setBrandName();
            item.setBrandIcon();
            item.setAvailableAmount();
            item.setDiscountAmount();
            item.setCategoryName(this.name);
            System.out.println("Successfully Add New Item");
            items.add(item);
        }
    }
    public void displayItems(){
        for(int i = 0; i < items.size(); i++){
            System.out.println("---------------------------");
            Item test = items.get(i);
            System.out.println("Item Name: " + test.getName());
            System.out.println("Item Description: " + test.getDescription());
            System.out.println("Item Price: " + test.getPrice());
            System.out.println("Available Amount: " + test.getAvailableAmount());
            System.out.println("Discount Amount: " + test.getDiscountAmount());
            System.out.println("Brand Name: " + test.getBrandName());
            System.out.println("Item Category: " + test.getCategoryName());
        }
        System.out.println("---------------------------");
    }

}
