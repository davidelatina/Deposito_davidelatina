class UtilitaMatematica {
  static int quadrato(int num) { // Metodo statico
    return num * num;
  }

  int cubo(int num) { // Metodo non statico
    return num * num * num;
  }
}

public class ProvaFunzioni {
  public static void main(String[] args) {

    System.out.println(UtilitaMatematica.quadrato(5)); //Nessun oggetto necessario
  
    UtilitaMatematica obj = new UtilitaMatematica();
  
    System.out.println(obj.cubo(5)); //Oggetto necessario
  }
}
