package my_RouterInterface;

public class Devices extends Thread {
    private String Device_Name;
    private String Device_Type;
    public static Router sharedRouter;
    static Semaphore objSem;
    Devices(String name, String type, Router obj, Semaphore objS)
    {
    	Device_Name= name;
    	Device_Type= type;
        sharedRouter = obj;
        objSem = objS;
        
    }
    public void run()
    {
        objSem.P(this);
        sharedRouter.occupy(this);
    	connect();
    	activity();
    	//after being all connected, logout
    	disconnect();
        sharedRouter.release();
    }
    public String getDevName()
    {
        return Device_Name;
    }
    public void connect()
    {
    	System.out.println(this.Device_Name+ "login");
    }
    
    public void activity()
    {
    	System.out.println(this.Device_Name + "Performs online activity");

    }
    
    public void disconnect()
    {
    	System.out.println(this.Device_Name+ "Logout");
        sharedRouter.release();
    }
}
