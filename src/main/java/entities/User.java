package entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by kopuz on 7/10/2018.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private long id;

    @Column
    private String userName;

    @Column
    private String userSurname;

    @Column
    private String userMotherName;

    @Column
    private String userFatherName;

    @Column
    private java.sql.Date userBirthDate;

    @Column
    private String userEmail;

    @Column
    private String telephoneNumber;

    @Column
    private String mobilePhoneNumber;

    @Column
    private String address;

    /**
     * CONSTRUCTORS
     */

    //Default Constructor
    public User() {

    }

    public User(String userName, String userSurname, String userMotherName, String userFatherName, java.sql.Date userBirthDate,
                String userEmail, String telephoneNumber, String mobilePhoneNumber, String address) {


        this.userName = userName;
        this.userSurname = userSurname;
        this.userMotherName = userMotherName;
        this.userFatherName = userFatherName;
        this.userBirthDate = userBirthDate;
        this.userEmail = userEmail;
        this.telephoneNumber = telephoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.address = address;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserMotherName() {
        return userMotherName;
    }

    public void setUserMotherName(String userMotherName) {
        this.userMotherName = userMotherName;
    }

    public String getUserFatherName() {
        return userFatherName;
    }

    public void setUserFatherName(String userFatherName) {
        this.userFatherName = userFatherName;
    }

    public Date getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(Date userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
