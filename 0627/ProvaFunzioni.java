

public class ProvaFunzioni {
  public static void main(String[] args) {

    int a = (int) (Math.random() * 101);
    int b = (int) (Math.random() * 101);

    System.out.println(a + " + " + b + " = " + somma(a,b));

    saluta();
  }

  static void saluta() {
    System.out.println("Ciao, Java!");
  }

  static int somma(int a, int b) {
    return a + b;
  }
}

