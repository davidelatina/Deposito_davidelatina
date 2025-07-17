package com.example.clienti;

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
      System.out.println("   MENU RICHIESTA DATI CLIENTI");
      System.out.println("0. Esci");
      System.out.println("1. Mostra tutti gli utenti il cui nome inizia con A");
      System.out.println("2. Conta quanti clienti sono registrati in ogni città.");
      System.out.println("3. Trova i 5 clienti più recenti");
      System.out.println("4. Lista di tutti i clienti dal più vecchio al più recente");

      int scelta = scannerNum.nextInt();

      if (scelta <= 0) {
        break;
      }

      switch (scelta) {
        case 1: // Mostra tutti gli utenti il cui nome inizia con A
          clientiA();
          break;

        case 2: // Conta quanti clienti sono registrati in ogni città.
          citta();
          break;

        case 3: // Trova i 5 clienti più recenti
          clientiRecenti();
          break;

        case 4: // Lista di tutti i clienti, a partire dal meno recente
          clientiTutti();
          break;

        default: // Fuori range
          System.out.println("Inserire una scelta valida.");
      }
    }

    scannerNum.close();
  }

  // Trova utenti il cui nome inizia con la A
  public static void clientiA() {

    String sql = """
        SELECT first_name
        FROM customer
        WHERE LOWER(first_name) LIKE 'a%'
        ORDER BY first_name ASC;
        """;

    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

      int i = 1;
      while (rs.next()) {
        System.out.println(i + ". " + rs.getString("first_name"));
        i++;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // Lista delle città con numero clienti
  public static void citta() {

    String sql = """
                SELECT ci.city, COUNT(cu.customer_id) AS customers
        FROM customer cu
        JOIN address a ON a.address_id = cu.address_id
        JOIN city ci ON ci.city_id = a.city_id
        GROUP BY ci.city
        ORDER BY customers DESC;""";

    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

      while (rs.next()) {
        System.out.println(
            rs.getString("ci.city") +
                ": " + rs.getInt("customers"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // Trova i 5 clienti più recenti
  public static void clientiRecenti() {

    String sql = """
        SELECT first_name, last_name, create_date
        FROM customer
        ORDER BY create_date DESC
        LIMIT 5;""";

    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

      while (rs.next()) {
        System.out.println(
            rs.getString("first_name") + " " +
                rs.getString("last_name") + " registered: " +
                rs.getDate("create_date"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // Lista di tutti i clienti, a partire dal meno recente
  public static void clientiTutti() {

    String sql = """
        SELECT first_name, last_name, create_date
        FROM customer
        ORDER BY create_date ASC;
        """;

    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

      while (rs.next()) {
        System.out.println(
            rs.getString("first_name") + " " +
                rs.getString("last_name") + " registered: " +
                rs.getDate("create_date"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}