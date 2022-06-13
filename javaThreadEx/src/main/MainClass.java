package main;

public class MainClass {

	public static void main(String[] args) {
		
		Thread thread1 = new ThreadEx("ping");
		Thread thread2 = new ThreadEx("pong");
		Thread thread3 = new ThreadEx("!!!");
		
		thread1.start();
		thread2.start();
		thread3.start();

	}

}
