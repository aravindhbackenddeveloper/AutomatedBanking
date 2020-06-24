package com.bank.api;
import java.util.Date;
import com.bank.api.Customer;

public class Account 
{
    
   public String          accountnumber;
   public BankBranch branchDetails = new BankBranch();
   public String          accountType;
   public double        accountBalance;
   public String          pin;
   public Date            doj;
   public Customer customer =new Customer();
   public boolean status ;

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public BankBranch getBranchDetails() {
        return branchDetails;
    }

    public void setBranchDetails(BankBranch branchDetails) {
        this.branchDetails = branchDetails;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public void generateAccountNumber( int count )
    {
        this.accountnumber = "CICICI-ACC-"+String.valueOf (count+1);
    }
}
