package GestioneBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

// Sistema gestione biblioteca

/*
Sfida Avanzata: Sistema di Gestione della Biblioteca
Requisiti Base:
1️⃣ Creare una Classe Book con:
String title (Titolo del libro)
String author (Autore del libro)
boolean isAvailable (Disponibilità del libro)
Metodo void displayBookInfo() → Mostra le informazioni del libro.
2️⃣ Creare una Classe Library con:
ArrayList<Book> books → Una lista dinamica di libri.
Metodo void addBook(Book book) → Aggiunge un libro alla biblioteca.
Metodo void displayBooks() → Mostra tutti i libri presenti nella biblioteca.
Metodo void borrowBook(String title) → Permette di prendere in prestito un libro
(solo se disponibile).
3️⃣ Implementare il Programma Principale per:
Aggiungere libri alla biblioteca.
Mostrare tutti i libri disponibili.
Permettere agli utenti di prendere in prestito un libro.
 */

public class GestioneBiblioteca {

  public static void main(String[] args) {
    // Dichiarazione scanner
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);


    Library libreria = new Library();

    ArrayList<User> utenti = new ArrayList<>();

    int scelta = -1;
    String bufferString = "";
    int bufferNum = -1;
    
    // Imposta primo utente come utente attivo
    utenti.add(new User("Pippo"));
    User activeUser = utenti.get(0);





    while (true) { // loop principale programma. si esce inserendo 8

      System.out.println("Utente attivo: " + activeUser.name);
      // Stampa libri presi in prestito
      System.out.print("Libri presi in prestito: ");
      if (activeUser.libriPrestito.size() == 0) {
        System.out.println("nessuno.");
      } else {
        for (Book bookIndex : activeUser.libriPrestito)
          System.out.print(bookIndex.title + ", ");
        System.out.println("");
      }
      // Selezione programma da parte dell'utente
      scelta = menuSelezione(scannerNum);

      if (scelta == 8)
        break; // <--- uscita dal programma

      switch (scelta) {
        case 1: // Aggiungi libro
          do {
            System.out.print("Inserire nome libro: ");
            bufferString = scannerString.nextLine();

            if (bufferString.isEmpty())
              continue;

            bufferString.trim();
            
            if(libreria.checkBookPresent(bufferString)) {
              System.out.println("Libro già presente");
              continue;
            } 

            System.out.print("Inserire nome autore: ");
            libreria.addBook(new Book(bufferString, scannerString.nextLine(), true));
          } while (false);
          break;
        case 2: // Lista libri
          libreria.displayBooks();
          break;
        case 3: // Prendi in prestito
          do {
            System.out.print("Inserire nome libro: ");
            bufferString = scannerString.nextLine();

            if (bufferString.isEmpty())
              continue;

            bufferString.trim();

            if (!libreria.checkBookPresent(bufferString)) {
              System.out.println("Libro non trovato");
              break;
            }

            libreria.borrowBook(
              libreria.searchBookByName(bufferString), activeUser);
          } while (false);
          break;    
        case 4: // Restituisci
          do {
            System.out.print("Inserire nome libro: ");
            bufferString = scannerString.nextLine();

            if (bufferString.isEmpty())
              continue;

            bufferString.trim();

            if (!libreria.checkBookPresent(bufferString)) {
              System.out.println("Libro non trovato");
              break;
            }

            libreria.returnBook(
              libreria.searchBookByName(bufferString), activeUser, scannerNum);
          } while (false);
          break;         
        case 5: // Cerca
          while (true) {
            System.out.print("Vuoi cercare per nome o autore? (n/a): ");
            bufferString = scannerString.nextLine();

            // Una stringa vuota porta .charAt(0) a lanciare un'eccezione
            if (bufferString.isEmpty())
              continue;

            bufferString.trim().toLowerCase();
            if (bufferString.charAt(0) == 'n' || bufferString.charAt(0) == 'a')
              break;
          }
          if (bufferString.charAt(0) == 'n') {
            while (true) { // Ricerca per nome
              System.out.print("Inserire nome libro: ");
              bufferString = scannerString.nextLine();

              if (!bufferString.isEmpty()) break;
              }
            bufferString.trim();
            libreria.printBooksByName(bufferString);
          } else {
            while (true) { // Ricerca per autore
              System.out.print("Inserire nome libro: ");
              bufferString = scannerString.nextLine();

              if (!bufferString.isEmpty())
                break;
            }
            bufferString.trim();
            libreria.printBooksByAuthor(bufferString); 
          }
          break;
          case 6: // Aggiungi utente
            while (true) {
              System.out.println("Inserire nome utente: ");
              bufferString = scannerString.nextLine();
              if (!bufferString.isBlank()) break;
              System.out.println("Inserire un nome valido.");
            }
            System.out.println("Utente registrato.");
            utenti.add(new User(bufferString));
            break;
          case 7: // Cambia utente attivo
            System.out.println("Lista utenti:");
            for (int i = 0; i < utenti.size(); i++) {
              System.out.println((i+1) + ". " + utenti.get(i).name);
            }
            while (true) {
              System.out.println("Seleziona codice utente (int): ");
              bufferNum = scannerNum.nextInt();
              bufferNum--; // Conversione "umano/macchina"
              if (0 <= bufferNum && bufferNum < utenti.size()) {
                break; 
              }
              System.out.println("Seleziona un codice utente valido.");
            }
            activeUser = utenti.get(bufferNum);
            break;
        default: // non dovrebbe essere raggiungibile
          System.out.println("Errore selezione programma");
          break;
      }
      System.out.println("");
    }

    // Chiusura scanner
    scannerNum.close();
    scannerString.close();
  }

  // Menu di selezione
  static int menuSelezione(Scanner scannerNum) {
    int scelta = -1;
    while (true) { // Loop continuo di selezione. uscita con selezione valida
      System.out.println("   Gestione Biblioteca");
      System.out.println("1. Aggiungi libro");
      System.out.println("2. Lista libri");
      System.out.println("3. Prendi in prestito");
      System.out.println("4. Restituisci");
      System.out.println("5. Cerca");
      System.out.println("6. Aggiungi utente");
      System.out.println("7. Cambia utente attivo");
      System.out.println("8. Esci");

      System.out.print("Scelta: ");

      scelta = scannerNum.nextInt();

      if (1 <= scelta && scelta <= 8)
        return scelta; // <--- Uscita funzione

      System.out.println("Inserire un numero da 1 a 8.");
    }
  }
}

class Library {
  static public int total = 0;

  ArrayList<Book> books;

  Library() {
    this.books = new ArrayList<>();
  }


  void addBook(Book book) {
    books.add(book);
    total++;
  }

  boolean checkBookPresent(String name) {
    if (total == 0) return false;
    for (Book book : books) {
      if (book.title.equalsIgnoreCase(name))
      return true;
    }
    return false;
  }

  Book searchBookByName (String name) {
    if (total == 0)
      return null;
    for (Book book : books) {
      if (book.title.equalsIgnoreCase(name))
        return book;
    }
    return null;
  }

  // Cerca libri per titolo
  void printBooksByName(String name) {
    if (total == 0) {
      return;
    }
    // Ignora maiuscole-minuscole
    name = name.toLowerCase();
    for (Book book : books) {
      if (book.title.toLowerCase().contains(name))
        book.displayBookInfo();
    }
  }

  Book searchBookByAuthor(String name) {
    if (total == 0)
      return null;
    for (Book book : books) {
      if (book.author.equalsIgnoreCase(name))
        return book;
    }
    return null;
  }

  
  // Cerca libri per autore
  void printBooksByAuthor(String name) {
    if (total == 0) {
      return;
    }
    // Ignora maiuscole-minuscole
    name = name.toLowerCase();
    for (Book book : books) {
      if (book.author.toLowerCase().contains(name))
        book.displayBookInfo();
    }
  }

  void displayBooks() {
    System.out.println("Libri della libreria:");
    if (total == 0) {
      System.out.println("Nessun libro.");
      return;
    }
    for (Book book : this.books) {
      book.displayBookInfo();
    }
  }

  // in input, un libro dell'oggetto libreria
  void borrowBook(Book bookRequested, User user) {
    if (bookRequested == null) {
      System.out.println("Errore");
      return;
    }
    
    for (Book bookIndex : this.books) {
      if (bookIndex.title.equalsIgnoreCase(bookRequested.title)) {
        if (bookIndex.available) { //libro trovato e disponibile
          if (user.libriPrestito.contains(bookRequested)) {
            System.out.println("Utente ha già preso in prestito questo libro.");
            return;
          }
          if (user.libriPrestito.size() >= 3) {
            System.out.println("Utente ha già preso in prestito " +
              "il limite massimo consentito di libri.");
            return;
          }
          // Aggiorna user
          user.libriPrestito.add(bookRequested);
          // Aggiorna indice libri
          bookIndex.available = false;
          System.out.println("Libro preso in prestito!");
          return;
        } else {
          System.out.println("Non disponibile");
          return;
        }
      }
    }
    System.out.println("Non trovato in lista");
  }

  // in input, un libro dell'oggetto utente
  void returnBook(Book bookRequested, User user, Scanner scannerNum) {
    if (bookRequested == null) {
      System.out.println("Errore");
      return;
    }

    // Verifica che utente possiede libro
    int bookIndex = user.libriPrestito.indexOf(bookRequested);
    if (bookIndex < 0) {
      System.out.println("Utente non possiede questo libro.");
      return;
    }

    // Verifica che biblioteca ha registrato libro
    bookIndex = this.books.indexOf(bookRequested);
    if (bookIndex < 0) {
      System.out.println("Questo libro appartiene a un'altra biblioteca.");
      return;
    }

    // Aggiorna user
    user.libriPrestito.remove(bookRequested);

    // Aggiorna indice libri
    this.books.get(bookIndex).available = true;
    System.out.println("Libro restituito");

    // Imposizione penale
    int giorni = -1;
    while (true) {
      System.out.print("Quanti giorni sono passati (int)? ");
      giorni = scannerNum.nextInt();
      if (giorni >= 0) break;
    }
    if (giorni > 14) System.out.println("Applicare penale.");
  }
}

class Book {
  String title;
  String author;
  boolean available;

  Book(String title, String author, boolean available) {
    this.available = true;
    this.title = title;
    this.author = author;
  }

  void displayBookInfo() {
    System.out.println(title + " - " + author + " - " +
      (available ? "" : "non ") + "disponibile");
  }
}

class User {
  static int userTotal = 0;

  String name;
  ArrayList<Book> libriPrestito;

  User(String name) {
    this.name = name;
    this.libriPrestito = new ArrayList<>();
  }
}


