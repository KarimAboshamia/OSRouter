package my_RouterInterface;

import java.util.logging.Level;
import java.util.logging.Logger;
import static my_RouterInterface.RouterInterface.Output;

public class Devices extends Thread {
    private String Device_Name;
    private String Device_Type;
    public static Router sharedRouter;
    private int connectionNumber;
    static Semaphore objSem;
    Devices(String name, String type, Router obj, Semaphore objS)
    {
    	Device_Name= name;
    	Device_Type= type;
        sharedRouter = obj;
        objSem = objS;
        
    }
    public void setConnection(int connection)
    {
        connectionNumber = connection;
    }
    public String getDevName()
    {
        return Device_Name;
    }
    
    public String getType()
    {
        return Device_Type;
    }
    
    public void connect()
    {
    	System.out.println("Connection "+ connectionNumber + ": "+ this.Device_Name+ " login");
    }
    
    public void activity()
    {
    	System.out.println("Connection "+ connectionNumber + ": " +this.Device_Name + " Performs online activity");        
    }
    
    public void disconnect()
    {
    	System.out.println("Connection "+ connectionNumber + ": " + this.Device_Name+ " Logout");
        sharedRouter.release();
    }
    
    public int getConnectionNumber()
    {
        return connectionNumber;
    }
    
    @Override
    public void run()
    {
        try {
            objSem.P(this);
            sharedRouter.occupy(this);
        } catch (Exception ex) {
            Logger.getLogger(Devices.class.getName()).log(Level.SEVERE, null, ex);
        }
    	connect();
    	activity();
    	disconnect();
        sharedRouter.release();
    }
}
