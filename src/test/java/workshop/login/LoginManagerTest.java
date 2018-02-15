package workshop.login;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class LoginManagerTest {

  private HashMap<String, String> userRepo;
  private LoginManager loginManager;

  @Before
  public void setUp() {
    // Arrange
    this.userRepo = new HashMap<String, String>();
    this.userRepo.put("myuser", "mypassword");
    this.loginManager = new LoginManager(userRepo);
  }

  @Test
  public void testLogin_CredentialsAreValid_ShouldReturnTrue() throws EmptyPasswordException, InvalidCredentialsException {
    // Arrange
    String username = "myuser";
    String password = "mypassword";

    // Act
    boolean result = loginManager.login(username, password);

    // Assert
    Assert.assertTrue(result);
  }

  // Assert
  @Test(expected = InvalidCredentialsException.class)
  public void testLogin_CredentialsAreNotValid_ShouldThrowInvalidCredentialsException() throws EmptyPasswordException, InvalidCredentialsException {
    // Arrange
    String username = "invaliduser";
    String password = "mypassword";

    // Act
    loginManager.login(username, password);
  }

  // Assert
  @Test(expected = EmptyPasswordException.class)
  public void testLogin_PasswordIsEmpty_ShouldThrowEmptyPasswordException() throws EmptyPasswordException, InvalidCredentialsException {
    // Arrange
    String username = "invaliduser";

    // Act
    loginManager.login(username, "");
  }
}
