
package my.RouterInterface;
import java.util.ArrayList; 


public class Router 
{
   
    ArrayList<Devices> listOfDevices = new ArrayList<Devices>();
    int numberOfConnections;
    int numberOfDevices;
    public Router(int num1, int num2)
    {
            numberOfConnections = num1;
            numberOfDevices = num2;
    }
    
    public void occupy(Devices dev)
    {
        
    }
    
    public void release(Devices dev)
    {
        
    }
}
