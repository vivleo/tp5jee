package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class coursDAO extends DAO{
    public coursDAO(String url,String login, String password){
        super(url, login, password);
        // TODO Auto-generated constructor stub
    }

    public boolean identifiantsCorrects(String login, String password)
    {
        Statement stmt = null;
        try {
            stmt = cn.createStatement();
            System.out.println("Statement Correct");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Statement Incorrect");
        }
        String sql = "SELECT * FROM user WHERE login='"+login+"' AND password='"+password+"';";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
            System.out.println("Requete Correcte");
            if (rs.next())
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Requete Incorrecte");
        }
        return false;
    }

    public String getEmployeeName(String intitule)
    {
        Statement stmt = null;
        try {
            stmt = cn.createStatement();
            System.out.println("Statement Correct");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Statement Incorrect");
        }
        String sql = "SELECT intitule,coef,duree FROM Cours WHERE intitule='"+intitule+";";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
            System.out.println("Requete Correcte");
            if (rs.next())
            {
                String s = rs.getString(1)+" "+rs.getString(2);
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Requete Incorrecte");
        }
        return "";
    }

}
