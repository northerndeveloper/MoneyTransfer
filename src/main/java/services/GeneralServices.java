package services;

import exception.TransferMoneyException;

/** Created by kopuz on 7/12/2018. */
public interface GeneralServices {

  void generateEntitiesForMoneyTransfer() throws TransferMoneyException;
}
