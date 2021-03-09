package maventest;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    String qry;
    Connection dbCon;
    Statement stmt;
    ArrayList<student> students = new ArrayList<student>();

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

        app.LoadData();

        int choice = -1;
        Scanner scn = new Scanner(System.in);

        while (choice != 5)
        {
            switch (choice)
            {
                case 1:
                {
                    for (int i = 0; i < app.students.size(); ++i)
                        app.students.get(i).Display();
                    break;
                }
                case 2:
                {
                    System.out.println("Enter student name, and major: ");
                    String name = scn.next();
                    String major = scn.next();
                    app.Insert(app, name, major); // update this function along with all of the others...
                    break;
                }
                case 3:
                {
                    System.out.println("Enter student id, name, and major: ");
                    int id = Integer.parseInt(scn.next());
                    String name = scn.next();
                    String major = scn.next();
                    app.Update(app, id, name, major);
                    break;
                }
                case 4:
                {
                    System.out.println("Enter student id to be deleted: ");
                    int id = scn.nextInt();
                    app.Delete(app, id);
                    break;
                }
                default:
                    break;
            }

            PrintMenu();
            choice = scn.nextInt();
        }

        scn.close();
    }

    private static void PrintMenu()
    {
        System.out.println("\n1. List all records\n2.Add a record\n3.Update a record\n4. Delete a record.\n5. Exit");
    }

    private void LoadData()
    {
        qry = "select * from students";

        try
        {
            PreparedStatement P = dbCon.prepareStatement(qry, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet r = P.executeQuery();

            while (r.next())
            {
                // load data into list here
                int id = r.getInt("studentID");
                String name = r.getString("studentName");
                String major = r.getString("studentMajor");
                student s = new student(id, name, major);

                students.add(s);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Can't locate reference to prepared statemnet: " + e.getMessage());
        }
    }

    private void GetRecord(int id)
    {
        qry = "select * from students where studentID = ?";

        try
        {
            PreparedStatement P = dbCon.prepareStatement(qry);

            P.setInt(1, id);

            ResultSet r = P.executeQuery();

            while (r.next())
            {
                System.out.println("studentName = " + r.getString("studentName") + " Major: " + r.getString("studentMajor"));
            }
        }
        catch(SQLException e)
        {
            System.out.println("Can't get reference to prepared statement.");
        }
    }

    private void Insert(App app, String name, String major)
    {
        qry = "insert into students(studentName, studentMajor) values (?, ?)";

        try
        {
            PreparedStatement P = dbCon.prepareStatement(qry);

            P.setString(1, name);
            P.setString(2, major);

            if (P.executeUpdate() > 0)
                System.out.println("Entry added to DB.");

            app.students.clear();
            app.LoadData();
        }
        catch(SQLException e)
        {
            System.out.println("Can't get reference to prepared statement: " + e.getMessage());
        }
    }

    private void Update(App app,int id, String name, String major)
    {
        qry = "update students set studentName = ?, studentMajor = ? where studentID = ?";

        try
        {
            PreparedStatement P = dbCon.prepareStatement(qry);

            P.setString(1, name);
            P.setString(2, major);
            P.setInt(3, id);

            if (P.executeUpdate() > 0)
                System.out.println("Record successfully updated.");

            app.students.clear();
            app.LoadData();
        }
        catch(SQLException e)
        {
            System.out.println("Can't get reference to prepared statement: " + e.getMessage());
        }
    }

    private void Delete(App app, int id)
    {
        qry = "delete from students where studentID = ?";

        try
        {
            PreparedStatement P = dbCon.prepareStatement(qry);

            P.setInt(1, id);

            if (P.executeUpdate() > 0)
                System.out.println("Record successfully deleted.");

            app.students.clear();
            app.LoadData();
        }
        catch(SQLException e)
        {
            System.out.println("Can't get reference to prepared statment: " + e.getMessage());
        }
    }
}
