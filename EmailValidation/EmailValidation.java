package EmailValidation;

import java.util.*;

public class EmailValidation
{
    public static void main(String[] args)
    {
        Set<String> emails = new TreeSet<String>();

        emails.add("test@email.com");
        emails.add("hello@fast.com");
        emails.add("school@testu.edu");
        emails.add("go@report.gov");

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter an email to search for:");
        String key = scn.next();

        //validate email
        String validEmail = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

        while (!key.matches(validEmail))
        {
            System.out.println("Invalid email, please try again:");
            key = scn.next();
        }

        //search for email
        if (emails.contains(key))
            System.out.println("Found email address " + key);
        else
            System.out.println("Email address " + key + " not found.");

        scn.close();
    }
}
