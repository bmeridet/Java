package Constructors;

public class Employee {
    private int empID;
    private String name;

    Employee()
    {
        empID = 0;
        name = "default";
    }

    Employee(int _empID, String _name)
    {
        empID = _empID;
        name = _name;
    }

    public void Display()
    {
        System.out.println("Emplyee ID: " + empID + " Name: " + name);
    }
}
