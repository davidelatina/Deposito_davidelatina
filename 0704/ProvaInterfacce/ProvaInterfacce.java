/*
Per accedere ai metodi dell'interfaccia, l'interfaccia deve essere "implementata" (un po' come ereditata) da un'altra classe con la implements parola chiave (invece di extends).
*/

 interface Animal {

  public void animalSound(); // interface method (does not have a body)

  public void sleep(); // interface method (does not have a body)
}

// Il corpo del metodo di interfaccia è fornito dalla classe definitiva
class Pig implements Animal {

  public void animalSound() {

    System.out.println("The pig says: wee wee");
  }

  public void sleep() {

    System.out.println("Zzz");
  }
}


class ProvaInterfaccie {

  public static void main(String[] args) {

    Pig myPig = new Pig();  

    // Animal non è una classe, ma può essere usato come tipo in condizioni o controlli.
    if (myPig instanceof Animal) {
      System.out.println("myPig è un animale.");
    }

    myPig.animalSound();

    myPig.sleep(); 
  }
}
