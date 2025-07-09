public class Main {
  public static void main(String[] args) {
    Singleton1 singleton1 = Singleton1.getInstance();
    singleton1.doSomething();
    System.out.println(singleton1.getPippo().nome);

    Singleton1 singleton2 = Singleton1.getInstance(); // rimane sempre la stessa
    singleton2.doSomething();

    if (singleton1 == singleton2) {
      System.out.println("Sempre lo stesso singleton.");
    }

    Logger_singleton log = Logger_singleton.getInstance();
    log.log("Logger_singleton: istanziato");
  }
}
