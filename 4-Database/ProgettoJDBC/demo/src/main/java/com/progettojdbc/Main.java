package com.progettojdbc;

import java.sql.*;

public class Main {
  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/sakila"; // sostituire con il nome del DB
    String user = "root";       // utente del DB
    String password = "dmty@Z'7(=x6";       // password del DB
    try (Connection conn = DriverManager.getConnection(url, user, password)) {
      System.out.println("Connessione riuscita");
    } catch (SQLException e) {
      System.out.println("Errore nella connessione");
      e.printStackTrace();
    }
  }
}