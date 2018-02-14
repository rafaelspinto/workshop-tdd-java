package workshop;

import java.util.HashMap;

public class LoginManager {


  private final HashMap<String, String> userRepo;

  public LoginManager(HashMap<String, String> userRepo) {
    this.userRepo = userRepo;
  }

  public boolean login(String username, String password) throws EmptyPasswordException, InvalidCredentialsException {
    if(userRepo.containsKey(username) && userRepo.get(username) == password ) {
      return true;
    }

    if(password.isEmpty()) {
      throw new EmptyPasswordException();
    }

    throw new InvalidCredentialsException();
  }
}
