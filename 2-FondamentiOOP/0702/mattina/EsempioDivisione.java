package mattina;

public class EsempioDivisione {

  public static int divisioneChecked(int a, int b) throws Exception {
    if (b == 0) {
      throw new Exception("Dividendo 0");
    }
    return a/b;
  }

  public static int divisioneUnchecked(int a, int b) {
    if (b == 0) {
      throw new RuntimeException("Dividendo 0");
    }
    return a / b;
  }
}
