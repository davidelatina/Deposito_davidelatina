public class AltreVariabili {
  public static void main(String[] args) {
    // Numero intero
    int provaNumero = 12;
    // Stringa di caratteri
    String provaTesto = "Ciao Mondo";
    // Variabili booleane
    boolean provaBool = true;
    boolean provaBool2;
    provaBool2 = true;
    provaBool2 = false;
    // Numero intero costante
    final int provaCostante = 15;
    // provaCostante = 20; // Genera errore

    System.out.println(provaTesto);
    String provaTesto2 = "Prova: ";
    // Concatenazione stringhe
    System.out.println(provaTesto2 + provaTesto + "!");

    // Assegnazioni, operazioni
    int x = 5, y = 6, z = 50;
    System.out.println(x + y + z);
    x = y = z = 50;
    System.out.println(x + y + z);
  }
}
