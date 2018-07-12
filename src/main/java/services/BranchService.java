package services;

import entities.Bank;
import entities.Branch;

/**
 * Created by kopuz on 7/10/2018.
 */
public interface BranchService {

    Branch createBranch(Bank bank);
}
