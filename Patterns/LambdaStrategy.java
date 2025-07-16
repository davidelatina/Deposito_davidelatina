// Pattern strategy utilizzando espressioni lambda e riferimenti a metodi.
// ref. "On Java 8" di Bruce Eckel

public class LambdaStrategy {
  public static void main(String[] args) {

    Strategy[] strategies = {
        new Strategy() { // [2]
          public String approach(String msg) {
            return msg.toUpperCase() + "!";
          }
        },
        msg -> msg.substring(0, 5), // [3]
        Unrelated::twice // [4]
    };

    Strategize s = new Strategize("Hello there");

    // Soft strategy di default
    s.communicate();

    // Itera attraverso tutte le altre strategies alternative.
    for (Strategy newStrategy : strategies) {
      s.changeStrategy(newStrategy); // [5]
      s.communicate(); // [6]
    }
  }
}

interface Strategy {
  String approach(String msg);
}

class Soft implements Strategy {
  public String approach(String msg) {
    return msg.toLowerCase() + "?";
  }
}

class Unrelated {
  static String twice(String msg) {
    return msg + " " + msg;
  }
}

// Context
public class Strategize {
  Strategy strategy;
  String msg;

  Strategize(String msg) {
    strategy = new Soft(); // [1]
    this.msg = msg;
  }

  void communicate() {
    System.out.println(strategy.approach(msg));
  }

  void changeStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}
/*
 * Output:
 * hello there?
 * HELLO THERE!
 * Hello
 * Hello there Hello there
 */

 /*
  * Strategy provides the interface that carries functionality in its single
  * approach() method. By creating different Strategy objects you create
  * different behavior.
  * 
  * Traditionally we implement this behavior by making a class that implements
  * the Strategy interface, as in Soft.
  * 
  * [1] In Strategize, you can see that Soft is the default strategy, as it is
  * assigned in the constructor.
  * 
  * [2] A slightly less verbose and more spontaneous approach is to create an
  * anonymous inner class. There’s still a fair amount of repetitious code, and
  * you always have to look at it until you say “oh, I see, they’re using an
  * anonymous inner class.”
  * 
  * [3] This is the Java 8 lambda expression, distinguished by the arrow ->
  * separating the argument and function body. To the right of the arrow is the
  * expression that is returned from the lambda. This achieves the same effect as
  * the class definition and anonymous inner class, but with a lot less code.
  * 
  * [4] This is the Java 8 method reference, distinguished by the ::. To the left
  * of the :: is the name of a class or object, and to the right of the :: is the
  * name of a method, but without an argument list.
  * 
  * [5] After using the default Soft strategy, we step through all the strategies
  * in the array and place each one into s using changeStrategy().
  * 
  * [6] Now, each call to communicate() produces different behavior, depending on
  * the strategy “code object” that’s being used at the moment. We pass behavior,
  * rather than only passing data.3
  * 
  * Prior to Java 8, we have been able to pass functionality via [1] and [2]
  * However, the syntax has been so awkward to write and read that we’ve only
  * done it when forced. Method references and lambda expressions make it
  * possible to pass functionality when you want to, instead of only when you
  * must.
  */