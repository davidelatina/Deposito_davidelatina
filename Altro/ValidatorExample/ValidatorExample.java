package ValidatorExample;

/**
 * @brief Classe utility per la verifica input utente da terminale. Da non
 *        istanziare nè ereditare.
 * 
 */
public final class ValidatorExample {

  // Numero maggiore di zero
  public static boolean greaterThanZero(int a) {
    return a > 0;
  }
  public static boolean greaterThanZero(double a) {
    return a > 0;
  }

  // Stringa con almeno n caratteri.
  public static boolean hasAtLeastNCharacters(String input, int n) {
    return input.length() >= n;
  }

  // Carattere è una vocale (nell'alfabeto latino)
  public static boolean isVowel(char c) {
    if ("AEIOUaeiou".indexOf(c) == -1) {
      return false;
    }
    return true;
  }

}


