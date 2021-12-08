package my_RouterInterface;

class Semaphore {

	protected int connections = 0;
        Devices dev;
	protected Semaphore() {
		connections = 0;
	}

	protected Semaphore(int initial) {
		connections = initial;
	}

	public synchronized void P(Devices dev) {
            connections--;
            if (connections < 0)
            {
                try 
                {
                    System.out.println(dev.getDevName() + "Arrived and waiting");
                    wait();//arrived
                } catch (InterruptedException e) 
                {
                    //arrived and waiting
                }
            }
            System.out.println(dev.getDevName() + "Arrived");
	}

	public synchronized void V() {
		connections++;
		if (connections <= 0)
			notify();
	}
}