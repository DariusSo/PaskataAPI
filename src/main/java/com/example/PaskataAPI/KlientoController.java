package com.example.PaskataAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.Objects;

@RestController
public class KlientoController {
    private static final String URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7713081";
    private static final String USERNAME = "sql7713081";
    private static final String PASSWORD = "H53CiPJX9t";
    private Connection connection;
    @GetMapping("/klientas")
    public int grazintiKlienta(String username, String password) throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        String sql = "SELECT * FROM klientas WHERE slapyvardis = ? AND slaptazodis = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet resultSet;

        resultSet = statement.executeQuery();

        int kID = -1;
        while (resultSet.next()) {
            kID = resultSet.getInt("id");
        }

        return kID;
    }
    @PostMapping("/klientas")
    public void pridetiKlienta(String username, String password) throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        String sql = "INSERT INTO klientas (slapyvardis, slaptazodis) VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        statement.executeUpdate();
    }
    @PostMapping("/klientoDuomenys")
    public String uzregistruotiDuomenis(int id, String vardas, String pavarde, String miestas, String telefonas ) throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        String sql1 = "SELECT id FROM klientas WHERE id = ?";
        PreparedStatement statement1 = connection.prepareStatement(sql1);
        statement1.setInt(1, id);
        ResultSet resultSet = statement1.executeQuery();
        int klientoId = -1;
        if(!resultSet.next()){
            return "Nera tokio kliento";
        }else{
            klientoId = resultSet.getInt("id");
        }

        String sql = "INSERT INTO kliento_duomenys (kliento_id, vardas, pavarde, miestas, telefonas) VALUES (?,?,?,?,?) " +
                "ON DUPLICATE KEY UPDATE vardas=?, pavarde=?, miestas=?, telefonas=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, klientoId);
        statement.setString(2, vardas);
        statement.setString(3, pavarde);
        statement.setString(4, miestas);
        statement.setString(5, telefonas);
        statement.setString(6, vardas);
        statement.setString(7, pavarde);
        statement.setString(8, miestas);
        statement.setString(9, telefonas);
        statement.executeUpdate();
        return "Pavyko";
    }

}
