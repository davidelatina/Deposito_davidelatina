package com.example.testgetenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.*;

public class Main {

  public static void main(String[] args) {

    // Caricamento variabili di ambiente
    Dotenv dotenv = Dotenv.load();
    String url = dotenv.get("url");
    String user = dotenv.get("user");
    String password = dotenv.get("password");

    try {

      Connection conn = DriverManager.getConnection(url, user, password);

      System.out.println("Connesso al database!");

    } catch (SQLException e) {

      e.printStackTrace();

    }

  }

}