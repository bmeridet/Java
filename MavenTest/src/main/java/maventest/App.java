package maventest;

import java.sql.*;

public class App 
{
    String qry;
    Connection dbCon;
    Statement stmt;

    App()
    {
        try
        {
            String urlConnect = "jdbc:mysql://localhost:3306/testdb";
            String usr = "root";
            String password = "";
            String mysqlDriver = "com.mysql.cj.jdbc.Driver";

            Class.forName(mysqlDriver);

            dbCon = DriverManager.getConnection(urlConnect, usr, password);

            stmt = dbCon.createStatement();

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
    public static void main( String[] args )
    {
        App app = new App();

        // test insert - works
        //app.Insert("hello");

        // test GetRecord - works
        //app.GetRecord(1);
        //app.GetRecord(2);

        // test Update - works
        //app.Update(2, "Hello World");

        // test Delete - works
        //app.Delete(2);
    }

    private void GetRecord(int id)
    {
        qry = "select * from testtable where testID = ?";

        try
        {
            PreparedStatement P = dbCon.prepareStatement(qry);

            P.setInt(1, id);

            ResultSet r = P.executeQuery();

            while (r.next())
            {
                System.out.println("testName = " + r.getString("testName"));
            }
        }
        catch(SQLException e)
        {
            System.out.println("Can't get reference to prepared statement.");
        }
    }

    private void Insert(String name)
    {
        qry = "insert into testtable(testName) values (?)";

        try
        {
            PreparedStatement P = dbCon.prepareStatement(qry);

            P.setString(1, name);

            if (P.executeUpdate() > 0)
                System.out.println("Entry added to DB.");

        }
        catch(SQLException e)
        {
            System.out.println("Can't get reference to prepared statement: " + e.getMessage());
        }
    }

    private void Update(int id, String name)
    {
        qry = "update testtable set testName = ? where testID = ?";

        try
        {
            PreparedStatement P = dbCon.prepareStatement(qry);

            P.setString(1, name);
            P.setInt(2, id);

            if (P.executeUpdate() > 0)
                System.out.println("Record successfully updated.");
        }
        catch(SQLException e)
        {
            System.out.println("Can't get reference to prepared statement: " + e.getMessage());
        }
    }

    private void Delete(int id)
    {
        qry = "delete from testtable where testID = ?";

        try
        {
            PreparedStatement P = dbCon.prepareStatement(qry);

            P.setInt(1, id);

            if (P.executeUpdate() > 0)
                System.out.println("Record successfully deleted.");
        }
        catch(SQLException e)
        {
            System.out.println("Can't get reference to prepared statment: " + e.getMessage());
        }
    }
}
