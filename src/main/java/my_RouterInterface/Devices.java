package my_RouterInterface;

import java.util.logging.Level;
import java.util.logging.Logger;
import static my_RouterInterface.RouterInterface.Output;

public class Devices extends Thread {
    private String Device_Name;
    private String Device_Type;
    public static Router sharedRouter;
    private int connectionNumber;
    //private Semaphore devSem;
    Devices(String name, String type, Router obj)
    {
    	Device_Name= name;
    	Device_Type= type;
        sharedRouter = obj;
        connectionNumber = 0;
        //objSem = objS;
        
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
    
    public int getConnectionNumber()
    {
        return connectionNumber;
    }
    
    public void connect() throws Exception
    {
    	System.out.println("Connection "+ connectionNumber + ": "+ this.Device_Name+ " login");
    	acquire();
        Output.append("Connection "+ connectionNumber + ": "+ this.Device_Name+ " login\n");
        release();
    }
    
    public void activity()
    {
    	System.out.println("Connection "+ connectionNumber + ": " +this.Device_Name + " Performs online activity");
    	acquire();
        Output.append("Connection "+ connectionNumber + ": " +this.Device_Name + " Performs online activity\n");
        release();
    }
    
    public void disconnect()
    {
        //sharedRouter.connections.V();
    	System.out.println("Connection "+ connectionNumber + ": " + this.Device_Name+ " logout");
    	acquire();
        Output.append("Connection "+ connectionNumber + ": " + this.Device_Name+ " logout\n");
        release();
        sharedRouter.release(this);
    }
    
    
    
    @Override
    public void run()
    {
        try {
            //objSem.P(this);
            connectionNumber = sharedRouter.occupy(this);
            connect();
            Thread.sleep(500);
            activity();
            Thread.sleep(500);
            disconnect();
        } catch (Exception ex) {
            Logger.getLogger(Devices.class.getName()).log(Level.SEVERE, null, ex);
        }
    	
    }
}
