/*
Crea una classe base Veicolo con gli attributi marca, modello e anno.
Crea una sottoclasse Auto che eredita da Veicolo e aggiunge l'attributo numeroPorte.
Crea una sottoclasse Moto che eredita da Veicolo e aggiunge l'attributo tipoManubrio.
Implementa un metodo toString() in tutte le classi per stampare le informazioni del veicolo.
Crea un programma principale che istanzia un oggetto Auto e un oggetto Moto, e stampa le loro informazioni.
 */



public class Esercizio1 {
  public static void main(String[] args) {

    Auto fiesta = new Auto("Ford", "Fiesta", 2010, 3);
    Moto moto = new Moto("Yamaha", "AB001", 2022, "Tipo B");

    System.out.println("Informazioni sui veicoli: \n" + fiesta + "\n" + moto);
  }
}


class Auto extends Veicolo {
  int numeroPorte;

  public Auto(String marca, String modello, int anno, int numeroPorte) {
    super(marca, modello, anno);
    this.numeroPorte = numeroPorte;
  }

  @Override
  public String toString() {
    return super.toString() + " numero porte: " + numeroPorte;
  }
}

class Moto extends Veicolo {
  String tipoManubrio;

  public Moto(String marca, String modello, int anno, String tipoManubrio) {
    super(marca, modello, anno);
    this.tipoManubrio = tipoManubrio;
  }

  @Override
  public String toString() {
    return super.toString() + " manubrio " + tipoManubrio;
  }
}

class Veicolo {
  String marca;
  String modello;
  int anno;
  public Veicolo(String marca, String modello, int anno) {
    this.marca = marca;
    this.modello = modello;
    this.anno = anno;
  }

  @Override
  public String toString() {
    return marca + " " + modello + " " + anno;
  }
}
