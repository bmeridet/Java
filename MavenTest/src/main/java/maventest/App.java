package maventest;

import java.sql.*;

public class App 
{
    public static void main( String[] args )
    {
        try
        {
            String urlConnect = "jdbc:mysql://localhost:3306/testdb";
            String usr = "root";
            String password = "";
            String mysqlDriver = "com.mysql.cj.jdbc.Driver";

            Class.forName(mysqlDriver);

            Connection dbCon = DriverManager.getConnection(urlConnect, usr, password);

            Statement stmt = dbCon.createStatement();

            System.out.println("Connection successful.");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Could not load driver: " + e.getMessage());
        }
        catch(SQLException e)
        {
            System.out.println("Could not connect to DB: " + e.getMessage());
        }
    }
}
