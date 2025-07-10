/*
Esercizio Medio:

Obiettivo:
    Simulare un sistema di avvio computer usando Facade.

Richiesta:
    Crea classi Bios, HardDisk, SistemaOperativo con metodi: inizializza(), carica(), avvia().
    Crea una classe ComputerFacade con metodo accendiComputer() che richiama i metodi appropriati in sequenza.
    In Main, istanzia il Facade e usa accendiComputer() per simulare l'avvio del PC.
 */


// Client
public class Main {
  public static void main(String[] args) {
    ComputerFacadeSingleton facade = ComputerFacadeSingleton.getInstance();
    facade.accendiComputer();
  }
}