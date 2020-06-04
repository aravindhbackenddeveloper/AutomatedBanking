package com.bank.api;

import java.util.ArrayList;

/**
 *
 * @author Aravindh
 */
public class Customer 
{
    public String customerId;
   String name;
    ArrayList<Account> accountList=new ArrayList<>();
    String address;
    long  phoneNumber;
    
    public void addAccountToCustomer(Account account)
    {
        this.accountList.add(account);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
   
}
