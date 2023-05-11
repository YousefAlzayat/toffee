public class app{

    static Toffee application = new Toffee();

    public void buildApp(){
        Item voucher1 = new Item("Voucher1", 5, "Description", 5, "TOFFEE", "", "Vouchers");
        Item voucher2 = new Item("Voucher2", 10, "Description", 5, "TOFFEE", "", "Vouchers");
        Item voucher3 = new Item("Voucher3", 25, "Description", 5, "TOFFEE", "", "Vouchers");
        Item voucher4 = new Item("Voucher4", 50, "Description", 5, "TOFFEE", "", "Vouchers");

        Category cat1 = new Category( "Vouchers", voucher1);
        cat1.addNewItem(voucher2);
        cat1.addNewItem(voucher3);
        cat1.addNewItem(voucher4);

        Item candy1 = new Item("Candy1", 5, "Description", 5, "TOFFEE", "", "Candys");
        Item candy2 = new Item("Candy2", 10, "Description", 5, "TOFFEE", "", "Candys");
        Item candy3 = new Item("Candy3", 25, "Description", 5, "TOFFEE", "", "Candys");
        Item candy4 = new Item("Candy4", 50, "Description", 5, "TOFFEE", "", "Candys");

        Category cat2 = new Category( "Candys", candy1);
        cat2.addNewItem(candy2);
        cat2.addNewItem(candy3);
        cat2.addNewItem(candy4);

        Item marshmellow1 = new Item("Marshmellow1", 5, "Description", 5, "TOFFEE", "", "Marshmellows");
        Item marshmellow2 = new Item("Marshmellow2", 10, "Description", 5, "TOFFEE", "", "Marshmellows");
        Item marshmellow3 = new Item("Marshmellow3", 25, "Description", 5, "TOFFEE", "", "Marshmellows");
        Item marshmellow4 = new Item("Marshmellow4", 50, "Description", 5, "TOFFEE", "", "Marshmellows");

        Category cat3 = new Category( "Marshmellows", marshmellow1);
        cat3.addNewItem(marshmellow2);
        cat3.addNewItem(marshmellow3);
        cat3.addNewItem(marshmellow4);

        application.accounts.add(new Account("yousef", "ahmed", "yousefalzayat02@yahoo.com", "2", "36 HIH", "01002684347", ""));

        application.categories.add(cat1);
        application.categories.add(cat2);
        application.categories.add(cat3);
    }
    
    public static void main(String[] args){
        
        application.displaySystem();
        // System.out.println("<OTP> 1234");
    }

};