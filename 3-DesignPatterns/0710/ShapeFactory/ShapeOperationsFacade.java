// Facade
public class ShapeOperationsFacade {

  public void operazioneUnificata() {

    // Factory dei factory
    ShapeFactoryFactory myShapeFactoryFactory = new ShapeFactoryFactory();

    // Factory delle shapes
    IShapeCreator myInvalidCreator = myShapeFactoryFactory.createShapeCreator("rectangle");
    if (myInvalidCreator == null) {
      System.out.println("Creatore di rettangoli non disponibile");
    }

    IShapeCreator myCircleCreator = myShapeFactoryFactory.createShapeCreator("circle");
    IShapeCreator mySquareCreator = myShapeFactoryFactory.createShapeCreator("square");

    // Creazione forme geometriche
    IShape circleRed = myCircleCreator.createShape("red");
    if (circleRed == null) {
      System.out.println("colore rosso non disponibile");
    }

    IShape circleWhite = myCircleCreator.createShape("white");
    IShape squareWhite = mySquareCreator.createShape("white");
    IShape circleBlack = myCircleCreator.createShape("black");
    IShape squareBlack = mySquareCreator.createShape("black");

    // Stampa finale
    circleWhite.draw();
    squareWhite.draw();
    circleBlack.draw();
    squareBlack.draw();
  }
}

// Sottosistema
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



