import exception.TransferMoneyException;
import services.GeneralServices;
import services.WebServiceServices;
import services.impl.GeneralServicesImpl;
import services.impl.WebServiceServicesImpl;

/** Created by kopuz on 7/1
 *
 *
 *
 *
 *
 * 0/2018. */
public class MoneyTransferMainApplication {

  public static void main(String[] args) throws TransferMoneyException {

    /** First it creates necessary services to send money */
    GeneralServices generalServices = new GeneralServicesImpl();

           generalServices.generateEntitiesForMoneyTransfer();

    /** Then it sends money by webservice */
              WebServiceServices webServiceServices = new WebServiceServicesImpl();



             webServiceServices.getMoneyTransfer();
  }
}
