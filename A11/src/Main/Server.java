package Main;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends ServerMain implements Runnable{
	/**
	 * default serial id
	 */
	private static final long serialVersionUID = 1L;
	ServerSocket sSocket; //empty the new server's socket
	Socket socket; //port

	InputStream input;
	
	public void start(int port, int a) {
		try {
			sSocket = new ServerSocket(port); // set port number
			if(a==0) { //if start
				Thread newClient = new Thread(new Server()); //new thread for server
				newClient.start(); //start thread
				

			} else if (a == 1) { //if close
				sSocket.close();
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(input != null) sSocket.close();
				if(socket != null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			} //try catch end
		} //try catch end
		
	} //start end

	@Override
	public void run() {
			try {
				socket = sSocket.accept(); // accept 
				addResult("Connecting "+socket.getInetAddress() + " at port " + socket.getPort());
				input = socket.getInputStream(); // read client's message
			} catch (IOException e) {
				ServerMain.addResult("Error!");
			} //try catch end
			
	} //run end

} //Server end
