package my_RouterInterface;

enum States
{
	connected,
	waiting,
	disconnected
}


public class Devices extends Thread {
    String Device_Name;
    String Device_Type;
    States State = States.disconnected;
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
    private void connect()
    {
    	System.out.println(this.Device_Name+ "login");
    }
    
    private void activity()
    {
    	System.out.println(this.Device_Name + "Performs online activity");

    }
    
    private void disconnect()
    {
    	System.out.println(this.Device_Name+ "Logout");
    }
}
