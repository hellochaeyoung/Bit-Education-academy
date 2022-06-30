package impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.function.BiConsumer;

public class HandlerServerExceptionConsumer implements BiConsumer<Socket, String> {

	@Override
	public void accept(Socket t, String u) {
		
		try {

			PrintWriter writer = new PrintWriter(t.getOutputStream());
			writer.println(u);
			writer.flush();
			System.out.println("[HandlerServerExceptionConsumer]>>>>>" + u);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	

}
