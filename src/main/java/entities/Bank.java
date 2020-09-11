package entities;

import javax.persistence.*;

/**
 * Created by kopuz on 7/10/2018.
 */
@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
          private long id;

    @Column
    private String bankName;

    /**
     * CONSTRUCTORS
     */

    //Default Constructor
    public Bank() {

    }

    /**
     * GETTERS & SETTERS
     */

    public Bank(String bankName) {



                        this.bankName = bankName;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
