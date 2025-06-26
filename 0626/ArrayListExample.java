import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
  public static void main(String[] args) {
    ArrayList<Integer> numeri = new ArrayList<>();

    // Aggiunta di 10 numeri casuali

    for (int i = 0; i < 10; i++) {
      numeri.add((int) (Math.random() * 100) + 1);
    }


    // Stampa della lista originale

    System.out.println("Lista originale: " + numeri);


    // Ordinamento della lista

    Collections.sort(numeri);


    // Stampa della lista ordinata

    System.out.println("Lista ordinata: " + numeri);
  }
}
