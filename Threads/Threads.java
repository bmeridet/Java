package Threads;

public class Threads implements Runnable {
    
    public static int count = 0;

    public void run()
    {
        while (Threads.count <= 10)
        {
            try
            {
                System.out.println("Function thread: " + ++(Threads.count));
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                System.out.println("Exception in thread: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Starting main thread...");

        Threads r = new Threads();
        Thread t = new Thread(r);

        t.start();

        while (Threads.count <= 10)
        {
            try
            {
                System.out.println("Main thread: " + ++(Threads.count));
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                System.err.println("Exception in main: " + e.getMessage());
            }
        }
    }
}
