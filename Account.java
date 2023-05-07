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
    private LoyalityPoints credits;
    private Order cart;

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

    // public void makeOrder(Order order){

    // }

    // public void reOrder(int orderId){

    // }

    public void displayOrderHistory(){

    }

    public void addToCart(Item item, int amount){
        if(cart == null) cart = new Order(this, Orders.size());

        cart.addItem(item, amount);

    }

    public void updatePassword(String newPassword){
        this.password = newPassword;
    }

}
