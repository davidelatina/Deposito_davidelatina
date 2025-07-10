public class ProvaOverloading {

  static void mostra(int numero) {
    System.out.println("Numero: " + numero);
  }

  static void mostra(String testo) {
    System.out.println("Testo: " + testo);
  }

  public static void main(String[] args) {
    
    // Chiama mostra(int)
    mostra(10);
    
    // Chiama mostra(String)
    mostra("Ciao"); 
  }
}
