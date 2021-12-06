
package my_RouterInterface;

import java.util.ArrayList;
public class Router 
{
    ArrayList<Devices> devN = new ArrayList<Devices>(); // Create an ArrayList object
    String devNames[];
    Semaphore connections;
    int numberOfConnections=0;
    int numberOfDevices; 
    
    public Router(int num1, int num2, String devNames[])
    {
            numberOfConnections = num1;
            numberOfDevices = num2;
            for(int i = 0; i < numberOfDevices; i++)
            {
                String [] temp = devNames[i].split(" ");
                Devices dev = new Devices(temp[0], temp[1]);
                devN.add(dev);
            }
    }
    
    public void occupy(Devices dev)
    {
    }
    
    public void release(Devices dev)
    {
        
    }
}
