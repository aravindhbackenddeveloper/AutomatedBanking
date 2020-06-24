package com.bank.api;

import com.database.bank.RegisterData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aravindh
 */
public class BankBranches 
{
    
    public ArrayList<BankBranch> branches=new ArrayList<BankBranch>();
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
    public ArrayList<BankBranch> getBranchList(ResultSet rs) throws SQLException
    {
        while( rs.next() )
       {
             BankBranch branch = new BankBranch();
             branch.branch_Name  =  rs.getString(1);
             branch.ifsc_code  =  rs.getString(2);
             branch.location  =  rs.getString(3);
             this.branches.add( branch );
       }
        return this.branches;
    }
    public int getCount() throws SQLException
    {
        int count;
        
        this.getBranchList( RegisterData.getBranch() );
        count = this.branches.size();
        
        return count;
    }
}
