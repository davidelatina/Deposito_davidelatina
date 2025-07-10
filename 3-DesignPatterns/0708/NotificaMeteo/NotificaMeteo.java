/* 
Esercizio Facile – Sistema di Notifica Meteo

Obiettivo: Simulare un sistema dove una stazione meteo (subject) notifica più display
(observer) quando cambia la temperatura.

Requisiti:

Creare un'interfaccia Display con il metodo aggiorna(float temperatura).

Implementare la classe StazioneMeteo con:

una lista di display registrati;

metodi aggiungiDisplay, rimuoviDisplay, notificaDisplay;

un metodo setTemperatura(float t) che aggiorna la temperatura e notifica.

Implementare almeno due display (es. DisplayConsole, DisplayMobile) che stampano il
valore ricevuto.


*/






public class NotificaMeteo {
  public static void main(String[] args) {
    
    StazioneMeteoSubject mySMeteo = new StazioneMeteoSubject();
    mySMeteo.setTemperatura(35.0f);

    DisplayConsoleObserver myDConsole = new DisplayConsoleObserver("Console Display");
    DisplayMobileObserver myDMobile = new DisplayMobileObserver("Mobile Display");


    mySMeteo.aggiungiDisplay(myDConsole);
    mySMeteo.aggiungiDisplay(myDMobile);

    mySMeteo.setTemperatura(37.0f);

    mySMeteo.rimuoviDisplay(myDMobile);

    mySMeteo.setTemperatura(38.0f);


    


  }
  
}
