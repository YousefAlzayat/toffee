import java.util.Scanner;
import java.util.regex.*;

public class Register {
    Scanner in = new Scanner(System.in);
    public void createAccount(Account a){
        System.out.print("Please enter your first name: ");
//        a.setFName(in.next());
        String fN = in.next();
        while(true){
            if(stringValidation(fN)){
                a.setFName(fN);
                break;
            }
            System.out.print("Please enter your first name: ");
            fN = in.next();
        }
        //-------------------------------------------------
        System.out.print("Please enter you second name: ");
//        a.setSName(in.next());
        String lN = in.next();
        while(true){
            if(stringValidation(lN)){
                a.setSName(lN);
                break;
            }
            System.out.print("Please enter your second name: ");
            lN = in.next();
        }
        //-------------------------------------------------
        System.out.print("Please enter your mail: ");
        String test = in.next();
        while(true){
            if(validMail(test)){
                a.setMail(test);
                break;
            }
            System.out.println("Enter another mail please: ");
            test = in.next();
        }
        //------------------------------------------------
        System.out.print("Please enter your password: ");
        String pass = in.next();
        while(true){
            if(checkPasswordGuidelines(pass)){
                a.setPassword(pass);
                break;
            }
            System.out.println("Enter another password please: ");
            pass = in.next();
        }
        //------------------------------------------------
        System.out.print("Please enter your address: ");
        a.setAddress(in.nextLine());
        in.nextLine();
        //------------------------------------------------
        System.out.print("Please enter your telephone number: ");
        String num = in.next();
        while(true) {
            if (checkTelephoneNumberGuidelines(num)) {
                a.setMobilePhone(num);
                break;
            }
            System.out.print("Please enter correct number: ");
            num = in.next();
        }
        //------------------------------------------------
        System.out.println("Did you have E-Wallet?\n1. YES.\n2. NO.");
        int ch = in.nextInt();
        if(ch == 1){
            System.out.print("Please, Enter E-Wallet Number: ");
            String ewallet = in.next();
            while(true){
                if(EWalletValidation(ewallet)){
                    a.setEWalletNum(ewallet);
                    break;
                }
                System.out.println("Please, Enter Correct E-Wallet Number: ");
                ewallet = in.next();
            }
        }else{
            a.setEWalletNum("0");
        }
    }
    //=----------------------------------------------------------------------------------------=

    public boolean validMail(String Email){
        if(Pattern.matches("[A-Za-z]+[0-9]*@{1}[a-z]+[.]{1}[a-z]+", Email)){
            return true;
        }
        System.out.println("Please follow mail guidelines which are:\n" +
                "1. Mail must contains lower & upper case letters.\n" +
                "2. Mail may contains numbers after letters for strong password.\n" +
                "3. Mail must contains @ following it with the path like 'nada123@gmail.com'.\n");
        return false;
    }
    //----------------------------------------------------------------------------------------
    public boolean checkPasswordGuidelines(String s){
        if(Pattern.matches("(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#!+^%$&*.<>;{})(]).{8,}", s)){
            return true;
        }
        System.out.println("1. Password must contain from 8 to 14 characters.\n" +
                "2. Each password must contain upper and lower case characters.\n" +
                "3. Each password must contain numbers.\n" +
                "4. Each password must contain special characters into it.");
        return false;
    }
    //----------------------------------------------------------------------------------------
    public boolean checkTelephoneNumberGuidelines(String num){
        if(Pattern.matches("(01)?[0-9]{9}", num)){
            return true;
        }
        System.out.println("Mobile contains only numbers and is 11 numbers long.");
        return false;
    }
    //----------------------------------------------------------------------------------------
    public boolean stringValidation(String word){
        if(Pattern.matches("[A-Za-z]+", word)){
            return true;
        }
        System.out.println("please, Enter only characters.");
        return false;
    }
    //-----------------------------------------------------------------------------------------
    public boolean EWalletValidation(String word){
        if(Pattern.matches("[0-9]{11}", word)){
            return true;
        }
        System.out.println("please, Enter only 11 number. ");
        return false;
    }
}
