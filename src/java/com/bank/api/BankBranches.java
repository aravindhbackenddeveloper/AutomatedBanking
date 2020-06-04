package com.bank.api;

import java.util.ArrayList;

/**
 *
 * @author Aravindh
 */
public class BankBranches 
{
    
    ArrayList<BankBranch> branches=new ArrayList<>();
    public void addBranch(BankBranch branch)
    {
        this.branches.add(branch);
    }
    
    public BankBranch getBranch(String ifscCode)
    {
        BankBranch searchBranch=null;
        for(BankBranch branch:this.branches)
        {
            if(branch.ifsc_code.equalsIgnoreCase(ifscCode))
            {
                searchBranch=branch;
            }
        }
        return searchBranch;
    }
    
}
