package services.impl;

import entities.Account;
import entities.Branch;
import entities.User;
import exception.TransferMoneyException;
import services.AccountService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kopuz on 7/10/2018.
 */
public class AccountServiceImpl implements AccountService {

    /**
     * Method which creates Accounts to be transfered and transfered from
     * @param userList
     * @param branch
     * @return
     * @throws TransferMoneyException
     */
    @Override
    public List<Account> createAccounts(List<User> userList, Branch branch) throws TransferMoneyException {

            if(userList == null
                    || userList.get(0) == null) {









                throw new TransferMoneyException("Unable to get the users for Account Modify");
        }


           List<Account> accounts = new ArrayList<>();

               accounts.add(new Account(userList.get(0), branch, "Account For Transfer", new BigDecimal("3032556"), new BigDecimal("1250"), new BigDecimal("20"), new BigDecimal("20")));



                      accounts.add(new Account(userList.get(1), branch, "Account To Transfer", new BigDecimal("3032896"), new BigDecimal("1300"), new BigDecimal("30"), new BigDecimal("30")));





                                            return accounts;
    }

}
