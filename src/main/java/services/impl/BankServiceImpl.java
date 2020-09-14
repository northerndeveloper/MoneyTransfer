package services.impl;

import entities.Bank;
import services.BankService;

/** Created by kopuz on 7/10/2018. */
public class BankServiceImpl implements BankService {

  /**
   * Method which create Bank entity
   *
   * @return
   */
  @Override
  public Bank createBank() {

    Bank bank = new Bank("Akbank");
    return bank;
  }
}
