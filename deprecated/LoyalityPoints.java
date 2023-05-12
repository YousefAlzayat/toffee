public class LoyalityPoints {
    
    private Account account;
    private int amount;


    public LoyalityPoints(Account account){
        this.account = account;
    }
    
    public void increaseCredits(Account account, int amount){

    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

}
