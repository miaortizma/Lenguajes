
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class AccountTest {
    private Account account;

    @BeforeTest
    public void before() {
        account = new Account();
    }

    @Test
    public void given20AndMin10_whenWithdraw5_thenSuccess() {
        assertTrue(account.withdraw(5));
    }

    @Test
    public void given20AndMin10_whenWithdraw100_thenFail() {
        assertFalse(account.withdraw(100));
    }

    @Test
    public void given20AndMin10_whenWithdraw15_thenFail() {
        assertFalse(account.withdraw(15));
    }

    @Test
    public void given20AndMin10_whenWithdraw10_thenSuccess() {
        assertTrue(account.withdraw(15));
    }
}