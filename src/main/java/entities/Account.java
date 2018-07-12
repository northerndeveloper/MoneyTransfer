package entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by kopuz on 7/10/2018.
 */
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public long id;

    @OneToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public User user;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Branch branch;

    @Column
    public String accountName;

    @Column
    public BigDecimal accountNumber;

    @Column
    public BigDecimal balanceInTurkishCurrency;

    @Column
    public BigDecimal balanceInEuro;

    @Column
    public BigDecimal balanceInUSD;

    /**
     * CONSTRUCTORS
     */

    /*
    Default Constructor
     */
    public Account() {

    }

    public Account(User user, Branch branch, String accountName, BigDecimal accountNumber, BigDecimal balanceInTurkishCurrency, BigDecimal balanceInEuro, BigDecimal balanceInUSD) {

        this.user = user;
        this.branch = branch;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balanceInTurkishCurrency = balanceInTurkishCurrency;
        this.balanceInEuro = balanceInEuro;
        this.balanceInUSD = balanceInUSD;
    }

    /**
     * GETTERS & SETTERS
     */

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBalanceInTurkishCurrency() {
        return balanceInTurkishCurrency;
    }

    public void setBalanceInTurkishCurrency(BigDecimal balanceInTurkishCurrency) {
        this.balanceInTurkishCurrency = balanceInTurkishCurrency;
    }

    public BigDecimal getBalanceInUSD() {
        return balanceInUSD;
    }

    public void setBalanceInUSD(BigDecimal balanceInUSD) {
        this.balanceInUSD = balanceInUSD;
    }

    public BigDecimal getBalanceInEuro() {
        return balanceInEuro;
    }

    public void setBalanceInEuro(BigDecimal balanceInEuro) {
        this.balanceInEuro = balanceInEuro;
    }

    public BigDecimal getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(BigDecimal accountNumber) {
        this.accountNumber = accountNumber;
    }
}
