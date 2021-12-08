
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
    
    public Router(int num1, int num2, String devNames[])throws Exception
    {
        //file = new FileWriter("Output.txt");
        numberOfConnections = num1;
        numberOfDevices = num2;
        devSemaphore = new Semaphore(numberOfConnections);
        out = new JTextField();
        for(int i = 0; i < numberOfDevices; i++)
        {
            String [] temp = devNames[i].split(" ");
            Devices dev = new Devices(temp[0], temp[1], this, devSemaphore);
            devN.add(dev);
            dev.start();
        }
    }
    
    public void occupy(Devices dev)throws Exception {
        System.out.println("Connection " + (devSemaphore.connections + 1) + ": " + dev.getDevName() + " occupied");
        Output.append("Connection " + (devSemaphore.connections + 1) + ": " + dev.getDevName() + " occupied\n");
        //out.write(file);
    }
    
    public void release()
    {
        devSemaphore.V();
    }
}
