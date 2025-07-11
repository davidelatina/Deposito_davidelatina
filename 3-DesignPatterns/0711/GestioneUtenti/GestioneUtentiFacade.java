// Client --- Facade
public class GestioneUtentiFacade {

  // Subsystem attraverso interfaccia adapter
  private UserManagement interfaceToLegacyUserSystem;

  void createUser(String nome) {
    interfaceToLegacyUserSystem.createUser(nome);
  }

  void deleteUser(String nome) {
    interfaceToLegacyUserSystem.deleteUser(nome);
  }

  void findUser(String key) {
    interfaceToLegacyUserSystem.findUser(key);
  }

  // Costruttore
  GestioneUtentiFacade() {
    // Creazione adattatore attraverso interfaccia
    this.interfaceToLegacyUserSystem = new UserManagementAdapter();
  }

  // Operazione Demo
  public void legacyUserSystemDemo() {
    
    // Creazione gruppo di utenti
    interfaceToLegacyUserSystem.createUser("Aldo Arbusti");
    interfaceToLegacyUserSystem.createUser("Aldo Alberti");
    interfaceToLegacyUserSystem.createUser("Bruno Berardi");
    interfaceToLegacyUserSystem.createUser("Carlo Carli");
    interfaceToLegacyUserSystem.createUser("Daniele Di Carlo");

    // Ricerca utente
    interfaceToLegacyUserSystem.findUser("aldo");

    // Eliminazione utente
    interfaceToLegacyUserSystem.deleteUser("aldo alberti");

    // Nuova ricerca: l'utente è stato eliminato.
    interfaceToLegacyUserSystem.findUser("aldo");
  }
}

