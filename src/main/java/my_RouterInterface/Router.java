
package my_RouterInterface;

import java.util.ArrayList;
public class Router 
{
    ArrayList<Devices> devN = new ArrayList<Devices>(); // Create an ArrayList object
    String devNames[];
    Semaphore connections;
    static int dev = 0;
    int numberOfConnections=0;
    private Semaphore devSemaphore;
    int numberOfDevices; 
    
    public Router(int num1, int num2, String devNames[])
    {
            numberOfConnections = num1;
            numberOfDevices = num2;
            devSemaphore = new Semaphore(numberOfConnections);
            for(int i = 0; i < numberOfDevices; i++)
            {
                String [] temp = devNames[i].split(" ");
                Devices dev = new Devices(temp[0], temp[1], this);
                devN.add(dev);
                dev.start();
            }
    }
    
    public void occupy()
    {
       while(dev < numberOfConnections)
       {
           devSemaphore.P();
           
           dev++;
       }
    }
    
    public void release()
    {
        devSemaphore.V();
        dev--;
    }
}
