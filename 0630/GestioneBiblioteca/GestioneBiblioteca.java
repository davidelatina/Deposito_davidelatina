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


    int scelta = -1;
    String bufferString = "";





    while (true) { // loop principale programma. si esce inserendo 5

      // Selezione programma da parte dell'utente
      scelta = menuSelezione(scannerNum);

      if (scelta == 6)
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

            libreria.borrowBook(libreria.searchBookByName(bufferString));  
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

            libreria.returnBook(libreria.searchBookByName(bufferString));
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
            if (libreria.checkBookPresent(bufferString)) {
              libreria.searchBookByName(bufferString).displayBookInfo();
              break;
            }  
          } else {
            while (true) { // Ricerca per autore
              System.out.print("Inserire nome libro: ");
              bufferString = scannerString.nextLine();

              if (!bufferString.isEmpty())
                break;
            }
            bufferString.trim();
            if (libreria.checkBookPresent(bufferString)) {
              libreria.searchBookByName(bufferString).displayBookInfo();
              break;
            }
          }
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
      System.out.println("6. Esci");

      System.out.print("Scelta: ");

      scelta = scannerNum.nextInt();

      if (1 <= scelta && scelta <= 6)
        return scelta; // <--- Uscita funzione

      System.out.println("Inserire un numero da 1 a 6.");
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

  Book searchBookByAuthor(String name) {
    if (total == 0)
      return null;
    for (Book book : books) {
      if (book.author.equalsIgnoreCase(name))
        return book;
    }
    return null;
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

  void borrowBook(Book bookRequested) {
    if (bookRequested == null) {
      System.out.println("Errore");
      return;
    }
    boolean bookFound = false;
    for (Book bookIndex : this.books) {
      if (bookIndex.title.equalsIgnoreCase(bookRequested.title)) {
        if (bookIndex.available) { //libro trovato disponibile
          bookIndex.available = false;
          System.out.println("Libro preso in prestito!");
        } else {
          System.out.println("Non disponibile");
        }
        bookFound = true;
        break;
      }
    }
    if (!bookFound) System.out.println("Non trovato in lista");
  }

  void returnBook(Book bookRequested) {
    if (bookRequested == null) {
      System.out.println("Errore");
      return;
    }
    boolean bookFound = false;
    for (Book bookIndex : this.books) {
      if (bookIndex.title.equalsIgnoreCase(bookRequested.title)) {
        if (bookIndex.available) { // libro trovato ancora disponibile
          System.out.println("Libro non preso in prestito, ancora disponibile");
        } else {
          bookIndex.available = true;
          System.out.println("Libro restituito");
        }
        bookFound = true;
        break;
      }
    }
    if (!bookFound)
      System.out.println("Non trovato in lista");
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


