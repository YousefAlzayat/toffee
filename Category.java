import java.util.Scanner;
import java.util.Vector;
public class Category {

    private String name;
    protected Vector<Item> items = new Vector<Item>();
    Scanner in = new Scanner(System.in);
    
    Category(){
        this.name = "";
    }

    Category(String n,Item i){
        this.name = n;
        items.add(i);
    }
    
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
            item.setCategoryName(this.name);
            items.add(item);
        }
    }

    public void displayItems(){
        for(int i = 0; i < items.size(); i++){
            Item test = items.get(i);

            System.out.println("------------=" + (i+1) +"=------------");
            System.out.println("Item Name: " + test.getName());
            System.out.println("Item Description: " + test.getDescription());
            System.out.println("Item Price: " + test.getPrice());
            if(test.getAvailableAmount() == 0) System.out.println("Stock: Out of Stock" );
            else System.out.println("Stock: " + test.getAvailableAmount());
            System.out.println("Discount Amount: " + test.getDiscountAmount());
            System.out.println("Brand Name: " + test.getBrandName());
        }
        System.out.println("---------------------------");
    }

}
