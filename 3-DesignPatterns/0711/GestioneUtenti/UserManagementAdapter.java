import java.util.ArrayList;

class User {
  String name;

  User(String name) {
    this.name = name;
  }
}

// Adaptee: classe legacy
class LegacyUserSystem {
  ArrayList<User> users;

  LegacyUserSystem() {
    this.users = new ArrayList<>();
  }

  void addUser(String name) {

    if (users.size() > 0) {
      for (User user : users) {
        if (name.equalsIgnoreCase(user.name)) {
          System.out.println("[LEGACY] user already present. " + name);
          return;
        }
      }
    }

    users.add(new User(name));
    
    System.out.println("[LEGACY] registered user " + name);
  }

  void removeUser(String name) {
    if (users.size() == 0) {
      return;
    }

    for (User user : users) {
      if (name.equalsIgnoreCase(user.name)) {
        users.remove(user);
        return;
      }
    }

  }

  void searchUser(String key) {
    if (users.size() == 0) {
      return;
    }

    System.out.println("[LEGACY] search results for \"" + key + "\"");
    for (User user : users) {
      if (user.name.toLowerCase().contains(key.toLowerCase())) {
        System.out.println("[LEGACY] " + user.name);
      }
    }

  }
}

// Target interface
interface UserManagement {
  void createUser(String nome);

  void deleteUser(String nome);

  void findUser(String key);
}

// Adapter --- Sottosistema di Facade
public class UserManagementAdapter implements UserManagement {
  private LegacyUserSystem legacyUserSystem;

  UserManagementAdapter() {
    this.legacyUserSystem = new LegacyUserSystem();
  }

  public void createUser(String nome) {
    legacyUserSystem.addUser(nome);
  }

  public void deleteUser(String nome) {
    legacyUserSystem.removeUser(nome);
  }

  public void findUser(String key) {
    legacyUserSystem.searchUser(key);
  }
}