package my_RouterInterface;
import java.io.FileWriter;
import static my_RouterInterface.RouterInterface.Output;

class Semaphore {

	protected int connections = 0;
        Devices dev;
	protected Semaphore() {
		connections = 0;
	}

	protected Semaphore(int initial) {
		connections = initial;
	}

	public synchronized void P(Devices dev)throws Exception {
            connections--;
            if (connections < 0)
            {
                try 
                {
                    //file.append("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived and waiting\n");
                    System.out.println("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived and waiting");
                    Output.append("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived and waiting\n");
                    wait();//arrived
                } catch (InterruptedException e) 
                {
                    //file.append("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived\n");
                    System.out.println("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived");
                    Output.append("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived\n");
                    //arrived
                }
            }
            //file.append("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived\n");
            System.out.println("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived");
            Output.append("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived\n");
        }

	public synchronized void V() {
		connections++;
		if (connections <= 0)
			notify();
	}
}