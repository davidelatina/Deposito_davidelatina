public class ProvaConversione {
  public static void main(String[] args) {
    int myInt = 9;

    // Casting automatico int to double
    double myDouble = myInt;

    System.out.println(myInt);     // 9
    System.out.println(myDouble);  // 9.0

    myDouble = 9.78d;
    // Casting manuale double -> int
    myInt = (int) myDouble;

    System.out.println(myDouble);  // 9.78
    System.out.println(myInt);     // 9
  }
  
}
