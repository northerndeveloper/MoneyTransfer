package services.impl;

import entities.Bank;
import entities.Branch;
import services.BranchService;

/** Created by kopuz on 7/10/2018. */
public class BranchServiceImpl implements BranchService {

  /**
   * Method which create Branch Entity
   *
   * @param bank
   * @return
   */
  @Override
  public Branch createBranch(Bank bank) {

    Branch branch = new Branch();
    branch.setBank(bank);
    branch.setBranchAddress("Akyazi Cad. Han.32");
    branch.setBranchCity("Istanbul");
    branch.setBranchCountry("Turkey");
    branch.setBranchName("Maslak");

    return branch;
  }
}
