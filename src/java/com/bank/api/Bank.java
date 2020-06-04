package com.bank.api;
/**
 *
 * @author Aravindh
 */

public class Bank
{
    
    Accounts accounts;
    Customers customers;
    BankBranches branches;
    
    Bank()
    {
        accounts=new Accounts();
        customers=new Customers();
        branches=new BankBranches();
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public BankBranches getBranches() {
        return branches;
    }

    public void setBranches(BankBranches branches) {
        this.branches = branches;
    }
    
}
