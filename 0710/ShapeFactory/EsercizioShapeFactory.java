/*
Design pattern ES Facile Factory Method

Crea un’interfaccia IShape con un metodo Draw(). Definisci
due classi concrete Circle e Square che implementano
IShape. Realizza una classe astratta ShapeCreator con il
metodo CreateShape(string type). 

Poi implementa due ConcreteShapeCreator (“creator”) che, a
seconda di “type” (“circle” o “square”), restituiscano
l’istanza corretta. 

Infine, scrivi un client che chieda all’utente quale forma
disegnare e la disegni tramite la funzione Draw()
 */

class EsercizioShapeFactory {
  public static void main(String[] args) {

    ShapeFactoryFactory myShapeFactoryFactory = new ShapeFactoryFactory();

    IShapeCreator myInvalidCreator = myShapeFactoryFactory.createShapeCreator("rectangle");

    if (myInvalidCreator == null) {
      System.out.println("Creatore di rettangoli non disponibile");
    }

    IShapeCreator myCircleCreator = myShapeFactoryFactory.createShapeCreator("circle");
    IShapeCreator mySquareCreator = myShapeFactoryFactory.createShapeCreator("square");

    IShape circleWhite = myCircleCreator.createShape("red");
    if (circleWhite == null) {
      System.out.println("colore rosso non disponibile");
    }

    circleWhite = myCircleCreator.createShape("white");
    IShape squareWhite = mySquareCreator.createShape("white");

    IShape circleBlack = myCircleCreator.createShape("black");
    IShape squareBlack = mySquareCreator.createShape("black");

    circleWhite.draw();
    squareWhite.draw();
    circleBlack.draw();
    squareBlack.draw();

  }
}

// Product Interface
interface IShape {
  void draw();
}

// Concrete Product
class Circle implements IShape {

  String color;

  Circle(String color) {
    this.color = color;
  }

  @Override
  public void draw() {
    if (color.equals("white")) {
      System.out.println("○");
    } else if (color.equals("black")) {
      System.out.println("●");
    }
  }
}

// Concrete Product
class Square implements IShape {

  String color;

  Square(String color) {
    this.color = color;
  }

  @Override
  public void draw() {
    if (color.equals("white")) {
      System.out.println("□");
    } else if (color.equals("black")) {
      System.out.println("■");
    }
  }
}

// Creator: dichiara il Factory Method
abstract class ShapeCreator implements IShapeCreator {
  // Factory Method: restituisce un Product
  public abstract IShape createShape(String tipo);
}

// Concrete Creator
class CircleFactory extends ShapeCreator {

  @Override
  public IShape createShape(String tipo) {
    if (tipo.equals("white") || tipo.equals("black")) {
      return new Circle(tipo);
    }

    return null;
  }
}

// Concrete Creator
class SquareFactory extends ShapeCreator {

  @Override
  public IShape createShape(String tipo) {
    if (tipo.equals("white") || tipo.equals("black")) {
      return new Square(tipo);
    }
    return null;
  }
}

// Product interface of Concrete Creator
interface IShapeCreator {
  IShape createShape(String tipo);
}

// Creator del creator
abstract class ShapeCreatorCreator {
  // Factory Method: restituisce un Product
  public abstract IShapeCreator createShapeCreator(String tipo);
}

// Concrete Creator of Concrete Creator
class ShapeFactoryFactory extends ShapeCreatorCreator {

  @Override
  public IShapeCreator createShapeCreator(String tipo) {
    if (tipo.equals("circle")) {
      return new CircleFactory();
    } else if (tipo.equals("square")) {
      return new SquareFactory();
    }

    System.out.println("there is no creator for " + tipo);
    return null;
  }
}
