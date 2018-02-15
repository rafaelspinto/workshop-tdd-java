package workshop.login;

import java.util.Map;

public class LoginManager {


  private final Map<String, String> userRepo;

  public LoginManager(Map<String, String> userRepo) {
    this.userRepo = userRepo;
  }

  public boolean login(String username, String password) throws EmptyPasswordThrowable, InvalidCredentialsThrowable {
    if(userRepo.containsKey(username) && userRepo.get(username) == password ) {
      return true;
    }

    if(password.isEmpty()) {
      throw new EmptyPasswordThrowable();
    }

    throw new InvalidCredentialsThrowable();
  }
}
