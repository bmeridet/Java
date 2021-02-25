package Threads;

public class ThreadedSend extends Thread {

    private String msg;
    private Thread t;
    Sender sender; 
    
    ThreadedSend(String _msg, Sender obj)
    {
        msg = _msg;
        sender = obj;
    }

    public void run()
    {
        synchronized (sender)
        {
            sender.Send(msg);
        }
    }
    
}
