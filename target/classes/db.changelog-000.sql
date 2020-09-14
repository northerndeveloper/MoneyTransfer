DROP TABLE IF EXISTS BANK;

create table BANK (
    id              int                 primary key  auto_increment,
    bankName        varchar(255)           not null
);

DROP TABLE IF EXISTS BRANCH;

create table BRANCH (
    id                     int                 primary key  auto_increment,
    branchName            varchar(255)          not null,
    branchAddress            varchar(255)       not null,
    branchCity            varchar(255)          not null,
    branchCountry            varchar(255)       not null,
    bank_id                int                not null references bank(id)
);

DROP TABLE IF EXISTS USER;

create table USER (
    id          int   primary key  auto_increment,
    userName        varchar(255),
    userSurname        varchar(255),
    userMotherName        varchar(255),
    userFatherName        varchar(255),
    userBirthDate        DATE,
    userEmail        varchar(255),
    telephoneNumber        varchar(255),
    mobilePhoneNumber        varchar(255),
    address        varchar(255)
);

DROP TABLE IF EXISTS ACCOUNT;

create table ACCOUNT (
    id                       INT PRIMARY KEY  AUTO_INCREMENT,
    user_id                  INT NOT NULL REFERENCES user (id),
    branch_id                INT NOT NULL REFERENCES branch (id),
    accountName              VARCHAR(255),
    accountNumber            INT,
    balanceInTurkishCurrency DECIMAL,
    balanceInEuro            DECIMAL,
    balanceInUSD             DECIMAL
);


