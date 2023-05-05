import java.util.ArrayList;
import java.util.Vector;
public class Category {
    private String name;
    private ArrayList<Item>I;
    public void addNewItem(Item item){
        for(int i = 0; i < I.size(); i++) {
            if(I.contains(item)){
                System.out.println("Item is already existing...");
            }
            String name;
            System.out.println("Please Enter Item Name");
            System.out.println("Successfully Add New Item");
            this.I.add(item);
        }
    }




}
