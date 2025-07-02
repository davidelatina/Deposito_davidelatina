public class TestDivisione {
  public static void main(String[] args) {

    try {
      EsempioDivisione.divisioneChecked(1, 1);
      try {
        EsempioDivisione.divisioneUnchecked(1, 0);
      } catch (Exception e) {
        e.printStackTrace();
        // All'utente meglio far vedere solo .getMessage()
        System.out.println(e.getMessage()); 
      }
      System.out.println("Ciao");
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("Programma terminato.");
  }
}
