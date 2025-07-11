/*
Esercizio Medio

Sviluppare un adattatore per integrare un sistema legacy di gestione utenti in una nuova
applicazione web.

Creare un'interfaccia chiamata UserManagement con metodi come createUser(),
deleteUser() e findUser().

Realizzare una classe LegacyUserSystem con metodi diversi quali addUser(),
removeUser() e searchUser().

Implementare un Adapter chiamato UserManagementAdapter che permetta alla nuova
applicazione di utilizzare il sistema legacy attraverso l'interfaccia definita.

Scrivere un piccolo programma dimostrativo che mostri come la nuova applicazione
riesca a gestire utenti tramite il sistema legacy adattato.
 */

public class Main {
  public static void main(String[] args) {
    // Creazione facade
    GestioneUtentiFacade facade = new GestioneUtentiFacade();

    // Operazione attraverso facade
    facade.legacyUserSystemDemo();
  }
}
