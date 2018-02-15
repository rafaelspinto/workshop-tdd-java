package workshop.payment;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaymentBrokerTest {

  private WalletInterface wallet;
  private PaymentProviderInterface provider;
  private PaymentBroker broker;

  @Before
  public void setUp() {
    // Arrange
    wallet = mock(WalletInterface.class);
    provider = mock(PaymentProviderInterface.class);
    broker = new PaymentBroker(wallet, provider);
  }

  @Test
  public void testPay_WalletHasFundsAndProviderIsAvailableAndDepositSucceeded_ShouldReturnTrue() throws InsufficientFundsException, ProviderNotAvailableException {
    // Arrange
    int amount = 10;
    int balance = 20;

    when(wallet.getBalance()).thenReturn(balance);
    when(provider.isAvailable()).thenReturn(true);
    when(provider.deposit(wallet.getId(), amount)).thenReturn(true);

    // Act & Assert
    Assert.assertTrue(broker.pay(amount));
  }

  // Assert
  @Test(expected = InsufficientFundsException.class)
  public void testPay_WalletDoesNotHaveFunds_ShouldThrowInsufficientFundsException() throws InsufficientFundsException, ProviderNotAvailableException {
    // Arrange
    int amount = 10;
    int balance = 9;

    when(wallet.getBalance()).thenReturn(balance);
    when(provider.isAvailable()).thenReturn(true);
    when(provider.deposit(wallet.getId(), amount)).thenReturn(true);

    // Act
    broker.pay(amount);
  }

  // Assert
  @Test(expected = ProviderNotAvailableException.class)
  public void testPay_ProviderIsNotAvailable_ShouldThrowProviderNotAvailableException() throws InsufficientFundsException, ProviderNotAvailableException {
    // Arrange
    int amount = 10;
    int balance = 20;

    when(wallet.getBalance()).thenReturn(balance);
    when(provider.isAvailable()).thenReturn(false);
    when(provider.deposit(wallet.getId(), amount)).thenReturn(true);

    // Act
    broker.pay(amount);
  }
}
