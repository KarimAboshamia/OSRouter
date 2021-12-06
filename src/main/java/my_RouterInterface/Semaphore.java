package my_RouterInterface;

class Semaphore {

	protected int connections = 0;

	protected Semaphore() {
		connections = 0;
	}

	protected Semaphore(int initial) {
		connections = initial;
	}
	public void setValue(int connections)
	{
		this.connections = connections;
	}

	public synchronized void P() {
		connections--;
		if (connections < 0)
			try {
				wait();
			} catch (InterruptedException e) {
			}
	}

	public synchronized void V() {
		connections++;
		if (connections <= 0)
			notify();
	}
}