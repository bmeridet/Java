package maventest;

public class student {

    private int studentID;
    private String studentName;
    private String studentMajor;

    public student(int id, String name, String major)
    {
        studentID = id;
        studentName = name;
        studentMajor = major;
    }

    // od getters and setters
    public void SetID(int id)
    {
        studentID = id;
    }

    public int GetID()
    {
        return studentID;
    }

    public void SetName(String name)
    {
        studentName = name;
    }

    public String GetName()
    {
        return studentName;
    }

    public void SetMajor(String major)
    {
        studentMajor = major;
    }

    public String GetMajor()
    {
        return studentMajor;
    }

    public void Display()
    {
        System.out.println(studentID + ": " + studentName + " " + studentMajor);
    }
    
}
