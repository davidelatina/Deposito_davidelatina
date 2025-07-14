// Interfaccia Component
interface Component {
  void getMessaggio();
}

// Componente Concreto
record MessaggioBase(String messaggio) {
  void getMessaggio() {
    System.out.print(this.messaggio);
  }
}

// Decorator astratto
abstract class Decorator implements Component {
  protected Component component;

  public Decorator(Component component) {
    this.component = component;
  }

  public void getMessaggio() {
    component.getMessaggio();
  }
}

/*
 * "\e[1mbold\e[0m"
 * "\e[3mitalic\e[0m"
 * "\e[4munderline\e[0m"
 */
// Decoratori Concreti
class BoldDecorator extends Decorator {
  public BoldDecorator(Component component) {
    super(component);
  }

  public void getMessaggio() {
    System.out.println("\\e[1m");
    super.getMessaggio();
    System.out.println("\\e[0m");
  }
}

class ItalicsDecorator extends Decorator {
  public ItalicsDecorator(Component component) {
    super(component);
  }

  public void getMessaggio() {
    System.out.println("\\e[3m");
    super.getMessaggio();
    System.out.println("\\e[0m");  }
}

class UnderlineDecorator extends Decorator {
  public UnderlineDecorator(Component component) {
    super(component);
  }

  public void getMessaggio() {
    System.out.println("\\e[1m");
    super.getMessaggio();
    System.out.println("\\e[4m");  }
}