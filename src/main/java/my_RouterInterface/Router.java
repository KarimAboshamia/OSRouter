
package my_RouterInterface;

import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JTextField;
import static my_RouterInterface.RouterInterface.Output;
public class Router 
{
    ArrayList<Devices> devN = new ArrayList<Devices>(); // Create an ArrayList object
    String devNames[];
    Semaphore connections;
    static int dev = 0;
    int numberOfConnections=0;
    static private Semaphore devSemaphore;
    int numberOfDevices; 
    FileWriter file;
    JTextField out;
    int counter = 0;
    
    public Router(int num1, int num2, String devNames[])throws Exception
    {
        numberOfConnections = num1;
        numberOfDevices = num2;
        devSemaphore = new Semaphore(numberOfConnections);
        out = new JTextField();
        for(int i = 0; i < devNames.length; i++)
        {
            String [] temp = devNames[i].split(" ");
            Devices dev = new Devices(temp[0], temp[1], this, devSemaphore);
            devN.add(dev);
            dev.start();
        }
    }
    
    public void occupy(Devices dev)throws Exception {
        System.out.println("Connection "+ dev.getConnectionNumber() + ": " + dev.getDevName() + " occupied");
    }
    
    public void release()
    {
    	counter++;
        devSemaphore.V();
        if(counter == numberOfDevices*2) {
        	System.out.println("Done");
        }
    }
}
