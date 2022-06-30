package threadex;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {
	
	String id;
	Socket socket;
	List<String> roomList = new ArrayList<>();
	
	public Client(Socket socket) {
		super();
		
		this.socket = socket;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public List<String> getRoomList() {
		return roomList;
	}
	
	
	
	
	
}
