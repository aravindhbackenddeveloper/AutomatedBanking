package com.bank.api;
import java.util.ArrayList;
import java.util.Date;

public class Customer 
{
    public String customerId;
    public String password;
    public String email;
    public String name;
    public String nationality;
    public String gender;
    public Date dob;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String address;
    public long  phoneNumber;
   
    ArrayList<Account> accountList=new ArrayList<>();
    

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email)
    {
        this.email=email;
    }
     public String getEmail()
     {
         return this.email;
     }
    public   void addAccountToCustomer(Account account)
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
   public void generateCustomerID(int count)
    {
        this.customerId = "CICICI-"+String.valueOf  (count+1);
    }
}
