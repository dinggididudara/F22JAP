package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends ServerMain implements Runnable{
	/**
	 * default serial id
	 */
	private static final long serialVersionUID = 1L;
	ServerSocket sSocket; //empty the new server's socket
	Socket socket; //port

	BufferedReader in;
	PrintWriter out;
	
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
			addResult("Server is already opened");
			e.printStackTrace();
		} finally {
			try {
				if(in != null) sSocket.close();
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
				in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // read socket's message
				out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
				
				String msg = null;
				msg = in.readLine();
				
				addResult("Message from client: "+ msg);
				
				out.write(msg);
				out.flush();
				socket.close();
			} catch (IOException e) {
				ServerMain.addResult("Error!");
			} //try catch end
			
	} //run end

} //Server end
