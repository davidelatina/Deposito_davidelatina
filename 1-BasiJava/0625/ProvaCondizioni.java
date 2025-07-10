public class ProvaCondizioni {
  public static void main(String[] args) {
    int x = 20;
    int y = 18;
    // Condizioni if... else if... else
    if (x > y) {
      System.out.println(x + " is greater than " + y);
    } else if (x == y) {
      System.out.println(x + " is equal to " + y);
    } else {
      System.out.println(x + " is not greater than " + y);
    }

    // Condizioni
    int time = 20;
    String result = (time < 18) ? "Good day." : "Good evening.";
    System.out.println(result);
  }
}
