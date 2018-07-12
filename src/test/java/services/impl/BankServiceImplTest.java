package services.impl;

import org.junit.Test;
import services.BankService;

import static org.junit.Assert.assertEquals;

/**
 * Created by kopuz on 7/12/2018.
 */
public class BankServiceImplTest {

    private BankService bankService = new BankServiceImpl();

    @Test
    public void testCreateBank() throws Exception {

        assertEquals(bankService.createBank().getBankName(), "Akbank");
    }
}