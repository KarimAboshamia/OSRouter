package my_RouterInterface;

public class Devices extends Thread {
    private String Device_Name;
    private String Device_Type;
    private Semaphore devSemaphore;
    public static Router sharedRouter;
    Devices(String name, String type)
    {
    	Device_Name= name;
    	Device_Type= type;
    }
    public void run()
    {
    	connect();
    	activity();
    	//after being all connected, logout
    	disconnect();
    }
    public void connect()
    {
        devSemaphore.P(this);
    	System.out.println(this.Device_Name+ "login");
    }
    
    public void activity()
    {
    	System.out.println(this.Device_Name + "Performs online activity");

    }
    
    public void disconnect()
    {
        devSemaphore.V(this);
    	System.out.println(this.Device_Name+ "Logout");
    }
}
