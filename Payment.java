public abstract class Payment {
    
    private Account account;
    private Order order;
    private int shippingFees;

    public void reducePriceByCredits(){}

    public void reducePriceByVouchers(){}

    public void confirmOperationByOTP(){

    }

    abstract void functionality();


}
