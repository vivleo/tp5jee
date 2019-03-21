package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    //Attributs

    private String url;
    private String login;
    private String password;
    public Connection cn;

    //Constructeur
    public DAO(String url, String login, String password) {
        super();
        this.url = url;
        this.login = login;
        this.password = password;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver OK");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver PROBLEM ");
        }

        try {
            cn = DriverManager.getConnection(url, login, password);
            System.out.println("Connection établie");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection non établie");
        }
    }
}
