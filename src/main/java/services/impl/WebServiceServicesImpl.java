package services.impl;

import static spark.Spark.get;
import static spark.Spark.port;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Account;
import exception.TransferMoneyException;
import java.math.BigDecimal;
import javax.persistence.*;
import services.WebServiceServices;

/** Created by kopuz on 7/12/2018. */
public class WebServiceServicesImpl implements WebServiceServices {

  private static ObjectMapper om = new ObjectMapper();

  /** Method which transfers money between accoutns */
  @Override
  public void getMoneyTransfer() {

    /* Change the port to 8080*/
    port(8080);

    get(
        "/moneyTransfer/:accountFromTransfer/:accountNumberToTransfer/:balanceToTransfer/:currency",
        (request, response) -> {
          String accountNumberFromTransfer = request.params(":accountFromTransfer");
          String accountNumberToTransfer = request.params(":accountNumberToTransfer");
          String balancetoTransfer = request.params(":balanceToTransfer");
          String currency = request.params("currency");

          EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("moneyTransfer");
          EntityManager em1 = emf1.createEntityManager();
          EntityTransaction tx1 = em1.getTransaction();
          tx1.begin();

          try {

            Query q =
                em1.createQuery(
                    "SELECT a FROM Account a WHERE a.accountNumber = :accountNumberFromTransfer");
            q.setParameter("accountNumberFromTransfer", new BigDecimal(accountNumberFromTransfer));

            // get single resutkl gelmesse ne olucakl
            Account accountFromTransfer =
                (Account) q.getResultList().get(0); // what happens if we get mroe than one result

            q =
                em1.createQuery(
                    "SELECT a FROM Account a WHERE a.accountNumber = :accountNumberToTransfer");
            q.setParameter("accountNumberToTransfer", new BigDecimal(accountNumberToTransfer));
            Account accountToTransfer = (Account) q.getResultList().get(0);

            if (currency.equalsIgnoreCase("TL")) {
              accountFromTransfer.setBalanceInTurkishCurrency(
                  accountFromTransfer
                      .getBalanceInTurkishCurrency()
                      .subtract(new BigDecimal(balancetoTransfer)));
              accountToTransfer.setBalanceInTurkishCurrency(
                  accountToTransfer
                      .getBalanceInTurkishCurrency()
                      .add(new BigDecimal(balancetoTransfer)));
            } else if (currency.equalsIgnoreCase("USD")) {
              accountFromTransfer.setBalanceInUSD(
                  accountFromTransfer
                      .getBalanceInTurkishCurrency()
                      .subtract(new BigDecimal(balancetoTransfer)));
              accountToTransfer.setBalanceInUSD(
                  accountToTransfer
                      .getBalanceInTurkishCurrency()
                      .add(new BigDecimal(balancetoTransfer)));
            } else if (currency.equalsIgnoreCase("EURO")) {
              accountFromTransfer.setBalanceInEuro(
                  accountFromTransfer
                      .getBalanceInTurkishCurrency()
                      .subtract(new BigDecimal(balancetoTransfer)));
              accountToTransfer.setBalanceInEuro(
                  accountToTransfer
                      .getBalanceInTurkishCurrency()
                      .add(new BigDecimal(balancetoTransfer)));
            } else {
              om.writeValueAsString(
                  "Problem happened during the transfer.Please check the logs for the problem");
              throw new TransferMoneyException(
                  "User can only have TL, USD or EURO account for now. Process is interrupted");
            }

            em1.merge(accountFromTransfer);
            em1.merge(accountToTransfer);
            tx1.commit();
          } catch (Exception e) {
            tx1.rollback();
            om.writeValueAsString(
                "Problem happened during the transfer.Please check the logs for the problem");
            throw new TransferMoneyException(
                "Unable to make transfer. Problem happened during transaction. Application will quit now",
                e);
          } finally {
            em1.close();
            emf1.close();
          }

          return om.writeValueAsString(
              "Transfer is completed successfully."
                  + balancetoTransfer
                  + " "
                  + currency
                  + " is transfered from"
                  + accountNumberFromTransfer
                  + " to "
                  + accountNumberToTransfer
                  + " successfully");
        });
  }
}
