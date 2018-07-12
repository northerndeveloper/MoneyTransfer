package services.impl;

import entities.Bank;
import entities.Branch;
import entities.User;
import org.junit.Test;
import services.AccountService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by kopuz on 7/12/2018.
 */
public class AccountServiceImplTest {

    AccountService accountService = new AccountServiceImpl();

    @Test
    public void testCreateAccounts() throws Exception {

        List<User> userList = new ArrayList<>();

        LocalDate userBirthday = LocalDate.of(1984, 5, 7);
        User user = new User("alper", "kopuz", "nilufer", "mustafa",  java.sql.Date.valueOf(userBirthday), "alperkopuz@gmail.com", "02163324559", "05333849638", "ortabayir mahallesi erler sokak no:3 daire:2 kagithane istanbul");
        userList.add(user);

        userBirthday = LocalDate.of(1980, 5, 7);
        user = new User("connor", "mcregor", "rebecca", "george",  java.sql.Date.valueOf(userBirthday), "gregorconnor@gmail.com", "004253698632", "00425689632", "ireland");
        userList.add(user);

        Bank bank = new Bank("Akbank");

        Branch branch = new Branch();
        branch.setBank(bank);
        branch.setBranchAddress("Akyazi Cad. Han.32");
        branch.setBranchCity("Istanbul");
        branch.setBranchCountry("Turkey");
        branch.setBranchName("Maslak");

        assertEquals(accountService.createAccounts(userList,branch).size(),2);
    }

}