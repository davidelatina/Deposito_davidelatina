/*
Crea una classe ContoBancario con gli attributi privati numeroConto,saldo e titolare.
Implementa i metodi pubblici getNumeroConto(),getSaldo(),getTitolare(),deposita(double importo)e preleva(double importo)per accedere e modificare i dati del conto.
Crea un programma principale che istanzia un oggetto ContoBancario,deposita e preleva fondi,e stampa il saldo finale.
*/

public class Esercizio2 {

  public static void main(String[] args) {
    ContoBancario contoPippo = new ContoBancario("Pippo");

    contoPippo.deposita(100.0);
    contoPippo.preleva(50.0);

    System.out.println("Saldo finale conto di " + contoPippo.getTitolare() + ": € " + contoPippo.getSaldo());
  }

}

class ContoBancario {
  private int numeroConto;
  private double saldo;
  private String titolare;

  public int getNumeroConto() {
    return numeroConto;
  }

  

  public double getSaldo() {
    return saldo;
  }

  public void deposita(double saldo) {
    this.saldo += saldo;
  }
  
  public void preleva(double saldo) {
    this.saldo -= saldo;
  }

  public String getTitolare() {
    return titolare;
  }

  public ContoBancario(String titolare) {
    this.numeroConto = 1;
    this.saldo = 0.0;
    this.titolare = titolare;
  }
}