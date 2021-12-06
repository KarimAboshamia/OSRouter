
package my_RouterInterface;

import java.util.ArrayList;
public class Router 
{
    Devices devices[];
    Semaphore connections;
    int numberOfConnections=0;
    int numberOfDevices; 
    
    public Router(int num1, int num2)
    {
            numberOfConnections = num1;
            numberOfDevices = num2;
        	devices= new Devices[numberOfDevices]; 
        	connections= new Semaphore(num1);
    }
    
    public void occupy(Devices dev)
    {
        
    }
    
    public void release(Devices dev)
    {
        
    }
}
