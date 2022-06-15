package main;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

import net.ReadThread;
import view.ClientFrame;

public class MainClass {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("192.168.0.12", 9000);
			System.out.println(">>> connection success!!");
			
			ClientFrame cf = new ClientFrame(socket);
			
			Set<String> set = new HashSet<>();
			
			new ReadThread(socket, cf, set).start();	
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
