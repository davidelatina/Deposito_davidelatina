/*
Esercizio Facile:

Obiettivo: creare una struttura base del pattern Decorator per decorare un messaggio di
testo.

Richiesta:
  Crea un'interfaccia Messaggio con un metodo String getContenuto().
  Implementa una classe concreta MessaggioBase che restituisce un messaggio semplice.
  Crea un decoratore DecoratoreMaiuscolo che trasforma il messaggio in maiuscolo.
  Scrivi una classe Main per mostrare il messaggio decorato a console.
 */

import java.util.Scanner;

public class EsercizioDecorator {
  public static void main(String[] args) {
    Scanner scannerStr = new Scanner(System.in);

    System.out.print("Inserire messaggio: ");

    // Oggetto base
    MessaggioBase myMessaggioBase = new MessaggioBase(scannerStr.nextLine());

    // Decoratore
    DecoratoreMaiuscolo myDecoratoreMaiuscolo = new DecoratoreMaiuscolo(myMessaggioBase);

    System.out.println("Messaggio originale: " + myMessaggioBase.getContenuto() + "\nMessaggio decorato: "
        + myDecoratoreMaiuscolo.getContenuto());

    scannerStr.close();
  }
}

// Interfaccia Component
interface Messaggio {
  String getContenuto();
}

// Componente Concreto
class MessaggioBase implements Messaggio {
  String messaggio;

  MessaggioBase(String messaggio) {
    this.messaggio = messaggio;
  }

  public String getContenuto() {
    return messaggio;
  }
}

// Decorator astratto
abstract class Decorator implements Messaggio {
  protected Messaggio component;

  public Decorator(Messaggio component) {
    this.component = component;
  }

  public String getContenuto() {
    return component.getContenuto();
  }
}

// Decoratore Concreto
class DecoratoreMaiuscolo extends Decorator {
  public DecoratoreMaiuscolo(Messaggio component) {
    super(component);
  }

  public String getContenuto() {
    return component.getContenuto().toUpperCase();
  }
}
