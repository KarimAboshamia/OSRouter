package my_RouterInterface;
import java.io.FileWriter;
import static my_RouterInterface.RouterInterface.Output;

class Semaphore {

	protected int connections;
        Devices dev;
        
	protected Semaphore() {
		connections = 0;
	}

	protected Semaphore(int initial) {
		connections = initial;
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

	public synchronized void P(Devices dev)throws Exception {
            connections--;
            if (connections < 0)
            {
                try 
                {
                    System.out.println("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived and waiting");
                    acquire();
                    Output.append("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived and waiting\n");
                    release();
                    wait();
                } catch (InterruptedException e) 
                {
                    System.out.println("Exception in waiting");
                }
            }
            else {
                System.out.println("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived");
                Output.append("(" + dev.getDevName() + ") (" + dev.getType() + ")" + " arrived\n");
            }
        }

	public synchronized void V() {
		connections++;
		if (connections <= 0)
			notify();
	}
}