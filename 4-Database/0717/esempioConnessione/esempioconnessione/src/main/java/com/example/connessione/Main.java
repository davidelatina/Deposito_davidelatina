package com.example.connessione;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

  public static void main(String[] args) {

    String url = "jdbc:mysql://localhost:3306/sakila";

    String user = "root";

    String password = "dmty@Z'7(=x6";

    try {

      Connection conn = DriverManager.getConnection(url, user, password);

      System.out.println("Connesso al database!");

    } catch (SQLException e) {

      e.printStackTrace();

    }

  }

}