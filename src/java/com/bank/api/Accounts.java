
package com.bank.api;

import java.util.ArrayList;

/**
 *
 * @author Aravindh
 */
public class Accounts 
{
    ArrayList<Account> accountList;
   
    Accounts()
    {
        accountList = new ArrayList<>();
    }
    public void addaccount(Account account)
    {
        this.accountList.add(account);
    }
    public Account getAccount(String accountNumber)
    {
        Account searchAccount=null;
        for(Account a : this.accountList)
        {
            if(a.accountnumber.equalsIgnoreCase(accountNumber))
            {
                searchAccount=a;
            }
        }
        return searchAccount;
    }
}
