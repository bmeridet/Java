package Constructors;

public class EmpMain {

    public static void main(String[] args)
    {
        Employee e1 = new Employee(); // Default constructor
        Employee e2 = new Employee(55, "Joe Smith"); // Parameterized constructor

        e1.Display();
        e2.Display();
    }
    
}
