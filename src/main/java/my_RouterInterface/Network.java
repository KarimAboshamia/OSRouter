package my_RouterInterface;

import java.util.Scanner;

public class Network {
	public static void main(String[] args) {
		Router my_router;
		System.out.println("Number of connections");
		try (Scanner input = new Scanner(System.in)) {
			int connectionNum = input.nextInt();
			System.out.println("Number of devices");
			int deviceNum = input.nextInt();
			my_router = new Router(connectionNum, deviceNum);
		}

	}

}
