/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.api;

/**
 *
 * @author Aravindh
 */
public class Account 
{
   String accountnumber;
   BankBranch branchDetails;
   String accountType;
   double accountBalance;

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
   
   
}
