package services.impl;

import entities.Bank;
import org.junit.Test;
import services.BranchService;

import static org.junit.Assert.assertEquals;

/**
 * Created by kopuz on 7/12/2018.
 */
public class BranchServiceImplTest {

    BranchService branchService = new BranchServiceImpl();

    @Test
    public void testCreateBranch() throws Exception {

        Bank bank = new Bank();
        bank.setBankName("Akbank");

        assertEquals(branchService.createBranch(bank).getBank().getBankName(),"Akbank");
        assertEquals(branchService.createBranch(bank).getBranchCity(),"Istanbul");
        assertEquals(branchService.createBranch(bank).getBranchCountry(),"Turkey");
        assertEquals(branchService.createBranch(bank).getBranchName(),"Maslak");
    }
}