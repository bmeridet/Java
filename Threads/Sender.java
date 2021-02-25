package Threads;

public class Sender {

    public void Send(String msg)
    {
        System.out.println("Sending\t" + msg);

        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Thread interupted.");
        }

        System.out.println("\n" + msg + " sent.");
    }

}
