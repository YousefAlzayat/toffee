import java.util.Scanner;
import java.util.regex.Pattern;

public class LogIn {
    Scanner in = new Scanner(System.in);
    String m;
    
    LogIn(){}

    public String enterMail(){
        System.out.print("Please Enter Your Mail: ");
        m = in.nextLine();
        return m;
    }

    public String enterPassword(){
        System.out.print("Please Enter Your Password: ");
        return in.nextLine();
    }

    public boolean checkPasswordGuidelines(String pass){
        if(Pattern.matches("(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#!+^%$&*.<>;{})(]).{8,}", pass)){
            return true;
        }
        System.out.println("1. Password must contain from 8 to 14 characters.\n" +
                "2. Each password must contain upper and lower case characters.\n" +
                "3. Each password must contain numbers.\n" +
                "4. Each password must contain special characters into it.");
        return false;
    }

    public String forgetPassword(){
        System.out.print("Please enter new password again: ");
        String m = in.nextLine();
        while(true) {
            if (!checkPasswordGuidelines(m)) {
                System.out.print("Please enter another password: ");
                m = in.nextLine();
            }else{
                System.out.print("Password Updated Successfully ^^");
                return m;
            }
        }
    }
}
