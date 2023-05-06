public class Order {
    
    private int id;
    private String date;
    private Account account;
    private int orderPrice;
    private Item[] orderedItems;
    private Payment payment;


    public Order(Account account, int id){
        this.account = account;
        this.id = id;
    }

}
