package services.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import services.BankService;

/** Created by kopuz on 7/12/2018. */
public class BankServiceImplTest {

  private BankService bankService = new BankServiceImpl();

  @Test
  public void testCreateBank() throws Exception {

    assertEquals(bankService.createBank().getBankName(), "Akbank");
  }
}
