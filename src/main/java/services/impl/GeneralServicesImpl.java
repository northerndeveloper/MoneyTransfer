package services.impl;

import entities.Account;
import entities.Bank;
import entities.Branch;
import entities.User;
import exception.TransferMoneyException;
import services.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by kopuz on 7/12/2018.
 */
public class GeneralServicesImpl implements GeneralServices {


    /**
     * Method which creates several entities
     */
    @Override
    public void generateEntitiesForMoneyTransfer() throws TransferMoneyException {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("moneyTransfer");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        BankService bankService = new BankServiceImpl();
        UserService userService = new UserServiceImpl();
        BranchService branchService = new BranchServiceImpl();
        AccountService accountService = new AccountServiceImpl();

        Bank bank = bankService.createBank();
        List<User> userList = userService.createUserList();
        Branch branch = branchService.createBranch(bank);

        List<Account> accounts = accountService.createAccounts(userList, branch);

        tx.begin();
        try {
            //TODO check if one persist is enough - during the code review
            em.persist(bank);
            em.persist(branch);

            for (User user : userList) { //TODO refactor it
                em.persist(user);
            }

            for (Account account : accounts) { //TODO refactor it
                em.persist(account);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }

    }


}
