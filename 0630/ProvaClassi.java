import java.util.ArrayList;

class Automobile {
  String marca;
  int anno;

  Automobile(String marca, int anno) {
    this.marca = marca;
    this.anno = anno;
  }
}

public class ProvaClassi {
  public static void main(String[] args) {
    ArrayList<Automobile> autoList = new ArrayList<>();
  
    autoList.add(new Automobile("Tesla", 2023));
    autoList.add(new Automobile("Ford", 2020));

    for (Automobile auto : autoList) {
      System.out.println(auto.marca + " - " + auto.anno);
    }
  }
}