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
                    wait();//arrived
                } catch (InterruptedException e) 
                {
                    //arrived and waiting
                }
            }
	}

	public synchronized void V(Devices dev) {
		connections++;
		if (connections <= 0)
			notify();
	}
}