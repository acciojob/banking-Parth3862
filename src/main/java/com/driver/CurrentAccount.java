package com.driver;

import javax.print.DocFlavor;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(balance<5000){
            throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId=tradeLicenseId;

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        boolean flag=false;
        for(int i=1;i<tradeLicenseId.length();i++){
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i-1)){
                flag=true;
                break;
            }
        }
        if(flag==true){
            String rearranged=rearrangedString(tradeLicenseId);
            if(rearranged!=null){
                tradeLicenseId=rearranged;
            }else{
                throw new Exception("Valid License can not be generated");
            }
        }
    }
    public String rearrangedString(String str){
        StringBuilder sb = new StringBuilder(str);
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                int j=i+1;
                while(str.charAt(j)!=str.charAt(i)){
                    j++;
                }
                if(j==str.length()){
                    return null;
                }
                char temp = str.charAt(i);
                sb.setCharAt(i,str.charAt(j));
                sb.setCharAt(j,temp);
                i++;
            }
        }
        return sb.toString();
    }

}
