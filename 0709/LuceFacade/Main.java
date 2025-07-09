/*
Esercizio Facile:

Obiettivo:
    Creare un sistema di accensione luci tramite Facade.

Richiesta:
    Crea due classi LuceCamera e LuceCucina con metodo accendi().
    Crea una classe GestioneLuciFacade che accende entrambe le luci tramite un unico metodo accendiTutte().
    In Main, istanzia il Facade e accendi tutte le luci con una sola chiamata.
 */


// Client
public class Main {
  public static void main(String[] args) {
    GestioneLuciFacade facade = new GestioneLuciFacade();
    facade.accendiTutte();
  }
}