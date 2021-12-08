package my_RouterInterface;
import java.io.FileWriter;
import static my_RouterInterface.RouterInterface.Output;

class Semaphore {

	protected int connections = 0;
        Devices dev;
        int temp;
	protected Semaphore() {
		connections = 0;
	}

	protected Semaphore(int initial) {
		connections = initial;
                temp = initial;
	}

	public synchronized void P(Devices dev)throws Exception {
            
            connections--;
            dev.setConnection(temp - connections);
            if (connections < 0)
            {
                try 
                {
                    System.out.println("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived and waiting");
                    Output.append("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived and waiting\n");
                    wait();
                } catch (InterruptedException e) 
                {
                    System.out.println("Exception in waiting");
                    Output.append("Exception in waiting");
                }
            }
            if(dev.getConnectionNumber() <= temp)
            {
                System.out.println("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived");
                Output.append("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived\n");
            }
            else
            {
                dev.setConnection(temp - connections);
            }
        }

	public synchronized void V() {
		connections++;
		if (connections <= 0)
			notify();
	}
}