public class Account {
    
    private String firstName;
    private String secondName;
    private String mail;
    private String password;
    private String address;
    private String mobilePhone;
    private int eWalletNumber;
    private Order[] Orders;
    private LoyalityPoints credits;

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

    public void setEWalletNum(int eWalletNumber){
        this.eWalletNumber = eWalletNumber;
    }

    public int getEWalletNum(){
        return eWalletNumber;
    }

    // public void makeOrder(Order order){

    // }

    // public void reOrder(int orderId){

    // }

    // public void displayOrderHistory(){

    // }

    // public void addToCart(Item item){

    // }

}
