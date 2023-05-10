import java.util.Vector;

public class Account {
    
    private String firstName;
    private String secondName;
    private String mail;
    private String password;
    private String address;
    private String mobilePhone;
    private String eWalletNumber;
    private Vector<Order> Orders = new Vector<Order>();
    // private LoyalityPoints credits;
    protected Order cart;

    Account(){}

    Account(String firstName, String secondName, String mail, String password, String address, String mobilePhone, String eWalletNumber){
        this.firstName = firstName;
        this.secondName = secondName;
        this.mail = mail;
        this.password = password;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.eWalletNumber = eWalletNumber;
    }

    public void setFName(String firstName){
        this.firstName = firstName;
    }

    public String getFName(){
        return firstName;
    }

    public void setSName(String secondName){
        this.secondName = secondName;
    }

    public String getSName(){
        return secondName;
    }

    public void setMail(String mail){
        this.mail = mail;
    }

    public String getMail(){
        return mail;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setMobilePhone(String mobilePhone){
        this.mobilePhone = mobilePhone;
    }

    public String getMobilePhone(){
        return mobilePhone;
    }

    public void setEWalletNum(String eWalletNumber){
        this.eWalletNumber = eWalletNumber;
    }

    public String getEWalletNum(){
        return eWalletNumber;
    }

    public boolean cartEmpty(){
        if(cart == null) return true;
        if(cart.orderedItems.size() == 0) return true;
        return false;
    }

    public void makeOrder(){
        cart.state = State.Shipping;
        Orders.add(cart);
        cart = null;
    }

    public void displayOrderHistory(){
        for(Order order : Orders){
            System.out.println("-----------------------");
            order.print();
        }
        System.out.println("-----------------------");
    }

    public void viewCart(){
        if(cart == null) System.out.println("Cart is Empty.");
        else cart.print();

    }

    public void addToCart(Item item, int amount){
        if(amount == 0) return;
        if(cart == null) cart = new Order(this, Orders.size());

        cart.addItem(item, amount);
    }

    public void updatePassword(String newPassword){
        this.password = newPassword;
    }

}
