package pomeriggio.EsercizioHotel;

import java.util.ArrayList;

/*
Esercizio: Gestione Semplice di un Hotel
  Obiettivi:
    Applicare incapsulamento (attributi privati e getter/setter).
    Applicare ereditarietà (almeno una sottoclasse di una classe base).
    Usare l’overload (sovraccarico) di almeno un metodo.
    Usare almeno un metodo statico.
Traccia
  Classe base Camera
    Attributi privati: numero (int), prezzo (float).
    Metodi getter/setter per tutti gli attributi.
    Metodo dettagli() che stampa info sulla camera.
  Overload di dettagli():
    Uno senza parametri: stampa tutto.
    Uno con parametro booleano conPrezzo: se true stampa anche il prezzo, altrimenti solo numero.
  Sottoclasse Suite (estende Camera)
    Attributo privato: serviziExtra (String).
    Getter/setter per serviziExtra.
    Override di dettagli(): stampa anche i servizi extra.
  Classe Hotel
    Attributo privato: nome (String).
    Attributo privato: lista di camere (ArrayList<Camera>).
    Metodo per aggiungere una camera.
    Metodo statico contaSuite(ArrayList<Camera> lista) che restituisce quante Suite ci sono nella lista.
  Nel main:
    Crea un hotel, aggiungi almeno 2 camere normali e 2 suite.
    Usa il metodo overload dettagli() in entrambe le forme.
    Usa il metodo statico per contare quante suite ci sono.
    Stampa l’output.
 */

public class GestioneHotel {
  public static void main(String[] args) {

    // Crea un hotel
    Hotel myHotel = new Hotel("myHotel");

    // Aggiungi 2 camere normali e 2 suite
    try {
      myHotel.aggiungiCamera(100.0f);
      myHotel.aggiungiCamera(100.0f);
      myHotel.aggiungiCamera(150.0f);

      myHotel.aggiungiCamera(200.0f, "Servizio in camera");
      myHotel.aggiungiCamera(200.0f, "Servizio in camera");
      myHotel.aggiungiCamera(300.0f, "Servizio in camera");

      // Solo eccezione prezzo
    } catch (PriceNegativeException e) { 

      System.out.println(e.getMessage());
      System.out.println("Errore previsto. Inserire nuovamente prezzo");
      
      // Ogni altra eccezione
    } catch (Exception e) { 
      System.out.println("Errore inaspettato. Esecuzione interrotta");
      System.out.println(e.getMessage());
      e.printStackTrace();
      
      // Uscita dal programma
      return;
    }

    // Usa il metodo statico per contare quante suite ci sono
    Hotel.contaSuite(myHotel.camere);

    // Stampa l’output.
    System.out.println("\nPrima stampa");
    for (Camera camera : myHotel.camere) {
      camera.dettagli();
    }

    System.out.println("\nStampa overload");
    for (Camera camera : myHotel.camere) {
      camera.dettagli(true);
    }
  }




}

class PriceNegativeException extends RuntimeException {
  PriceNegativeException(String msg) {
    super(msg);
  }
};

class Hotel {
  // Variabili d'istanza
  int numeroCamere = 0;
  String nome;
  ArrayList<Camera> camere = new ArrayList<>();

  Hotel(String nome) {
    this.nome = nome;
  }

  // Aggiungi camera
  void aggiungiCamera(float prezzo) throws PriceNegativeException {
    // --- Verifica argomenti
    if (prezzo < 0.0) {
      throw new PriceNegativeException("Il costo per notte delle camere deve essere maggiore di zero.");
    }

    // --- Corpo funzione
    numeroCamere++;
    this.camere.add(new Camera(numeroCamere, prezzo));
  }

  // Aggiungi suite
  void aggiungiCamera(float prezzo, String serviziExtra) throws PriceNegativeException {
    // --- Verifica argomenti
    if (prezzo < 0.0) {
      throw new PriceNegativeException("Il costo per notte delle camere deve essere maggiore di zero.");
    }
    if (serviziExtra.trim().isBlank()) {
      // Senza servizi extra, non è una suite ma solo una camera
      aggiungiCamera(prezzo);
      return;
    }

    // --- Corpo funzione
    numeroCamere++;
    this.camere.add(new Suite(numeroCamere, prezzo, serviziExtra));
  }


  // Metodi statici
  static void contaSuite(ArrayList<Camera> camere) {
    int c = 0;
    int s = 0;
    for (Camera camera : camere) {
      if (camera instanceof Suite) {
        s++;
      } else {
        c++;
      }
    }
    System.out.println("Ci sono " + c + " camere e " + s + " suite.");
  }
}

class Suite extends Camera {
  private String serviziExtra;

  Suite(int numero, float prezzo, String serviziExtra) {
    super(numero, prezzo);
    this.serviziExtra = serviziExtra;
  }

  public String getServiziExtra() {
    return serviziExtra;
  }

  public void setServiziExtra(String serviziExtra) {
    this.serviziExtra = serviziExtra;
  }

  @Override
  void dettagli() {
    super.dettagli();
    System.out.println("Servizi extra: " + serviziExtra);
  }
}

class Camera {
  private int numero;
  private float prezzo;

  Camera(int numero, float prezzo) {
    this.numero = numero;
    this.prezzo = prezzo;
  }

  // Getters e setters
  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public float getPrezzo() {
    return prezzo;
  }

  public void setPrezzo(float prezzo) {
    this.prezzo = prezzo;
  }

  // Stampa tutto
  void dettagli() {
    System.out.println("Camera n. " + numero + ", € " + prezzo + " a notte");
  }

  // Con prezzo
  void dettagli(boolean conPrezzo) {
    if (conPrezzo) {
      this.dettagli();
      return;
    }
    System.out.println("Camera n. " + numero);
  }
}
