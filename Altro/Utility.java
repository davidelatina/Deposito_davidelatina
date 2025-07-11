import java.util.*;

import ValidatorExample.ValidatorExample;
import MenuInput.MenuInput;

public abstract class Utility {

  /**
   * @brief Funzione main dedita solo a testare le funzionalità di MenuInput
   * 
   */
  public static void main(String[] args) {
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    int scelta = -1;

    ArrayList<String> menuDinamico = new ArrayList<>();
    menuDinamico.add("Menu dinamico");
    menuDinamico.add("Esci");
    menuDinamico.add("Aggiungi opzione");

    // Valori in lettura
    String bufferString = "";
    int bufferInt = -1;
    double bufferDouble = -1.0;

    while (true) {

      scelta = MenuInput
          .menuInt(
              scannerNum,
              new String[] {
                  "Test",
                  "Exit",
                  "selectionByChar",
                  "verifiedInputString",
                  "verifiedInputIntRange",
                  "verifiedInputDoubleRange",
                  "Dynamic menu"
              });

      if (scelta <= 1) {
        break;
      }

      switch (scelta) {
        case 2: // selectionByChar
          char sel = MenuInput.selectionByChar(scannerString, "qwerty", "uiop", new char[] { 'a', 'b', 'c' });

          // esempio di verifica eseguita esternamente
          if (ValidatorExample.isVowel(sel)) {
            System.out.println(sel + " + una vocale");
          } else {
            System.out.println(sel + " + non è una vocale");
          }
          break;

        case 3: // verifiedInputString
          bufferString = MenuInput.verifiedInputString(scannerString, "insert string: ", "insert a valid string", false, false, false);
          break;

        case 4: // verifiedInputIntRange
          bufferInt = MenuInput.verifiedInputIntRange(0, Integer.MAX_VALUE, scannerNum, "insert int: ", "insert a valid int");

          // esempio di verifica eseguita esternamente
          if (ValidatorExample.greaterThanZero(bufferInt)) {
            System.out.println(bufferInt + " è maggiore di zero");
          } else {
            System.out.println(bufferInt + " non è maggiore di zero");
          }
          break;

        case 5: // verifiedInputDoubleRange
          bufferDouble = MenuInput.verifiedInputDoubleRange(0.0, Double.MAX_VALUE, scannerNum, "insert double: ", "insert a valid double");

          // esempio di verifica eseguita esternamente
          if (ValidatorExample.greaterThanZero(bufferDouble)) {
            System.out.println(bufferDouble + " è maggiore di zero");
          } else {
            System.out.println(bufferDouble + " non è maggiore di zero");
          }
          break;

        case 6: // dynamic menu
          while (true) {
            scelta = MenuInput.dynamicMenu(scannerNum, menuDinamico, false);
            if (scelta == 1) {
              break;
            } else if (scelta == 2) {
              menuDinamico.add("Scelta vuota");
            }
          }
          break;

        default: // Should be unreachable
          System.out.println("Error");
          break;
      }
    }

    scannerString.close();
    scannerNum.close();
  }

}
