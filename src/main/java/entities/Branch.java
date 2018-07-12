package entities;

import javax.persistence.*;

/**
 * Created by kopuz on 7/10/2018.
 */
@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private long id;

    @Column
    private String branchName;

    @Column
    private String branchAddress;

    @Column
    private String branchCity;

    @Column
    private String branchCountry;

    @OneToOne(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Bank bank;

    /**
     * CONSTRUCTORS
     */

    /*
    Default Constructor
     */
    public Branch() {
    }

    public Branch(String branchName, String branchAddress, String branchCity, Bank bank) {
        this.branchName = branchName;
        this.branchAddress = branchAddress;
        this.branchCity = branchCity;
        this.bank = bank;
    }


    /**
     * GETTERS & SETTERS
     */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getBranchCity() {
        return branchCity;
    }

    public void setBranchCity(String branchCity) {
        this.branchCity = branchCity;
    }

    public String getBranchCountry() {
        return branchCountry;
    }

    public void setBranchCountry(String branchCountry) {
        this.branchCountry = branchCountry;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
