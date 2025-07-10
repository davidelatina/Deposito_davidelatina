import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();


    list.toString();

  }
}

// Decoratore Concreto B
class ConcreteDecoratorB extends Decorator {
  public ConcreteDecoratorB(Component component) {
    super(component);
  }

  public void operation() {
    System.out.println("Aggiunta funzionalità B");
    super.operation();
  }
}
