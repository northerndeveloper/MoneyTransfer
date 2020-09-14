package services;

import entities.Account;
import entities.Branch;
import entities.User;
import exception.TransferMoneyException;
import java.util.List;

/** Created by kopuz on 7/10/2018. */
public interface AccountService {

  List<Account> createAccounts(List<User> userList, Branch branch) throws TransferMoneyException;
}
