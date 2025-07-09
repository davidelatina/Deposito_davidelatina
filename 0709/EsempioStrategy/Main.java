
public class Main {
  public static void main(String[] args) {
    // Uso da parte del Client
    Context context = new Context();
    context.setStrategy(new ConcreteStrategyA());
    context.performTask(); // Output: Strategia A eseguita.
    context.setStrategy(new ConcreteStrategyB());
    context.performTask(); // Output: Strategia B eseguita.
  }
}
