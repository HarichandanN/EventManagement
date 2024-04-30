package com.invensis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCheck {
    private String jdbcURL = "jdbc:mysql://localhost:3306/Hari";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Hari";

    private static final String SELECT_ROLE_SQL = "SELECT Role FROM eventregister WHERE Name = ? AND Password = ?";

    public LoginCheck() {
    }

    protected Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public String getRole(String username, String password) {
        String role = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE_SQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                role = rs.getString("Role");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return role;
    }
}
