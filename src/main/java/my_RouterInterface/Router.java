
package my_RouterInterface;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
//import javax.swing.JTextField;
import static my_RouterInterface.RouterInterface.Output;
public class Router 
{
    Devices devN[]; // Create an ArrayList object
    Semaphore connections;
    int numberOfConnections;
    int numberOfDevices; 
    int counter;
    
    public Router(int num1)throws Exception
    {
        devN = new Devices[num1];
        Arrays.fill(devN, null);
        connections = new Semaphore(num1);
        numberOfConnections = num1;
    }
    static boolean available = true;
    public void acquire()
    {
    	while(!available);
    	available = false;
    }
    public void release()
    {
    	available = true;
    }
    public int occupy(Devices dev)throws Exception {
        connections.P(dev);
        int i = 0;
        for (i = 0; i < numberOfConnections; i++) {
            if(devN[i] == null){
                devN[i] = dev;
                System.out.println("Connection "+ (i + 1) + ": " + dev.getDevName() + " occupied");
                acquire();
                Output.append("Connection "+ (i + 1) + ": " + dev.getDevName() + " occupied\n");
                release();
                return (i+1);
            }
        }
        return 0;
    }
    public void release(Devices dev)
    {
       connections.V();
       for (int i = 0; i < numberOfConnections; i++) {
        if(devN[i] == dev){
                devN[i] = null;
            }
        }
    }
}
