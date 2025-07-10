import java.util.Scanner;

public class ProvaScanner {
  public static void main(String[] args) {
    // Create scanner object
    Scanner myObj = new Scanner(System.in);
    System.out.println("Enter username");
    // Read user input
    String userName = myObj.nextLine();
    // Output
    System.out.println("Username is: " + userName);
    myObj.close();
  }
}