package Main;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends ServerMain{
	/**
	 * default serial id
	 */
	private static final long serialVersionUID = 1L;
	ServerSocket sSocket = null; //empty the new server's socket
	Socket socket; //port
	OutputStream output;
	
	public void start(int port) {
		try {
			sSocket = new ServerSocket(port); // set port number
			while (true) {
				socket = sSocket.accept(); // accept client to write
				output = socket.getOutputStream(); // read client's message
				String send = "Hello"; // send message to client
				output.write(send.getBytes()); //write to output
		} //while end
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(output != null) sSocket.close();
				if(socket != null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			} //try catch end
		} //try catch end
		
	} //start end
			
} //Server end
