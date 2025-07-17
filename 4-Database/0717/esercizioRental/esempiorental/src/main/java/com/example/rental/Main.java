package com.example.rental;

import java.util.Scanner;
import java.sql.*;


public class Main {
  static final String URL = "jdbc:mysql://localhost:3306/sakila";
  static final String USER = "root";
  static final String PASSWORD = "dmty@Z'7(=x6";

  public static void main(String[] args) {
    Scanner scannerNum = new Scanner(System.in);


    while (true) {

      System.out.println("");
      System.out.println("   MENU SAKILA RENTAL");
      System.out.println("1. Esci");
      System.out.println("2. Mostra i 10 film più noleggiati");
      System.out.println("3. Mostra tutti i film a partire dal meno noleggiato");

      int scelta = scannerNum.nextInt();

      if (scelta <= 1) {
        break;
      }


      switch (scelta) {
        case 2: // Mostra i 10 film più noleggiati

          readMovies(true);

          break;

        case 3: // Mostra tutti i film in ordine, dal meno noleggiato

          readMovies(false);


          break;

        default: // Fuori range
          System.out.println("Inserire una scelta valida.");
      }
    }





    scannerNum.close();
  }


  // Leggi lista film
    public static void readMovies(boolean dalPiuNoleggiato) {


    String sql = """
      SELECT film.title, COUNT(rental.rental_id) AS numero_noleggi
      FROM film
      JOIN inventory ON film.film_id = inventory.film_id
      JOIN rental ON inventory.inventory_id = rental.inventory_id
      GROUP BY film.title
      ORDER BY numero_noleggi"""
          + (dalPiuNoleggiato ? " DESC LIMIT 10" : " ASC") + ";";

      /*
    if (dalPiuNoleggiato) {
      sql.concat("DESC LIMIT 10;");
    } else {
      sql.concat("ASC;");
    }*/


    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

      while (rs.next()) {
        System.out.println(
            "Film:  " + rs.getString("film.title") +
            "\tN_nol: " + rs.getInt("numero_noleggi"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
