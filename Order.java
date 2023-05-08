import java.util.Vector;

enum State {
    Pending, Shipping, Delivered, Cancelled;
}

public class Order {
    
    private int id;
    // private String date;
    private Account account;
    private int orderPrice;
    protected Vector<Item> orderedItems = new Vector<Item>();
    private Vector<Integer> orderedAmounts = new Vector<Integer>();
    // private Payment payment;
    protected State state = State.Pending;

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
        orderPrice += item.getPrice()*amount;
    }

    public void print(){

        if(state != State.Pending) System.out.println("Order Number: " + id);
        else System.out.println("Cart: ");

        System.out.println("Total Price: $" + orderPrice);
        System.out.println("Order Items: ");
        for (int i = 0; i < orderedItems.size(); i++) {
            System.out.println("x" + orderedAmounts.get(i) + "   " + orderedItems.get(i).getName() + "   $" + (orderedAmounts.get(i)*orderedItems.get(i).getPrice()));
        }

    }

}
