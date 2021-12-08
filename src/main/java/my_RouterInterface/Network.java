package my_RouterInterface;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTextField;

public class Network {
    
    Router mainRouter;
    
    Network(int numOfRouterConnections, int numOfDevices, String[] devicesNames) throws Exception {
           
	mainRouter = new Router(numOfRouterConnections);
        Devices buffer[] = new Devices[numOfDevices];
        JTextField out = new JTextField();
        for(int i = 0; i < devicesNames.length; i++)
        {
            String [] temp = devicesNames[i].split(" ");
            Devices dev = new Devices(temp[0], temp[1], mainRouter);
            buffer[i] = dev;
            dev.start();
        }
    }

}
