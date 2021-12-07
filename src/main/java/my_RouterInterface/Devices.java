package my_RouterInterface;

public class Devices extends Thread {
    private String Device_Name;
    private String Device_Type;
    public static Router sharedRouter;
    Devices(String name, String type, Router obj)
    {
    	Device_Name= name;
    	Device_Type= type;
        sharedRouter = obj;
        
    }
    public void run()
    {
        sharedRouter.occupy();
    	connect();
    	activity();
    	//after being all connected, logout
    	disconnect();
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
