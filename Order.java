import java.util.Vector;

enum State {
    Pending, Processing, Shipping, Delivered, Cancelled;
}

public class Order {
    
    private int id;
    private String date;
    private Account account;
    private int orderPrice;
    private Vector<Item> orderedItems = new Vector<Item>();
    private Vector<Integer> orderedAmounts = new Vector<Integer>();
    private Payment payment;
    private State state = State.Pending;

    public Order(Account account, int id){
        this.account = account;
        this.id = id;
    }

    public void setOrderPrice(int orderPrice){
        this.orderPrice = orderPrice;
    }

    public int getOrderPrice(){
        return orderPrice;
    }

    public void addItem(Item item, int amount){
        orderedItems.add(item);
        orderedAmounts.add(amount);
    }

    public void printOrder(){

        if(state != State.Pending) System.out.println("Order Number: " + id);
        else System.out.println("Cart: ");
        System.out.println("Price: " + orderPrice);
        System.out.println("Order Items: ");
        for (Item item : orderedItems) {
            System.out.println(item.getName());
        }

    }

}
