public class EsempioClassi {
  public static void main(String[] args) {
    // NomeClasse nomeOggetto = new NomeClasse();

    Auto miaAuto = new Auto(); // Creazione oggetto

    miaAuto.marca = "Tesla"; // Assegnazione valori

    miaAuto.anno = 2023;

    miaAuto.prezzo = 59999.99;


    miaAuto.mostraInfo(); // Output: Tesla - 2023 - €59999.99
    
  }
}

class Auto {
  String marca;
  int anno;
  double prezzo;

  void mostraInfo() {
    System.out.println(marca + " - " + anno + " - € " + prezzo);
  }
}
