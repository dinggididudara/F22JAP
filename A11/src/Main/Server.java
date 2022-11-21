package Main;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends ServerMain implements Runnable{
	/**
	 * default serial id
	 */
	private static final long serialVersionUID = 1L;
	ServerSocket sSocket = null; //empty the new server's socket
	Socket socket; //port
	OutputStream output;
	int nclinet=0, nclients=0;
	
	public void start(int port, int a) {
		try {
			sSocket = new ServerSocket(port); // set port number
			if(a==0) {
				Thread serverThread = new Thread(new Server()); //new thread for server
				serverThread.start(); //start thread
				
//				String send = "Hello"; // send message to client
//				output.write(send.getBytes()); // write to output

			} else if (a == 1) {
				sSocket.close();
				socket.close();
			}
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

	@Override
	public void run() {
		for(;;) {
			try {
				socket = sSocket.accept(); // accept 
				nclinet += 1;
				nclients += 1;
				addResult("Connecting "+socket.getInetAddress() + " at port " + socket.getPort());
				output = socket.getOutputStream(); // read client's message
			} catch (IOException e) {
				ServerMain.addResult("Error!");
			} //try catch end
			Connecting c = new Connecting(socket,nclinet);
			c.start();
		} //for end
	} //run end
	
	
	public class Connecting extends Thread{
		int clientid, p;
		String str;
		public Connecting(Socket s, int nclient) {
			socket = s; clientid = nclient;
		} //Connecting end
		
		public void run() {
			String data;
			PrintStream out = null; //empty output
			DataInputStream in = null; //empty input
			try {
				socket = sSocket.accept();
				out = new PrintStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				out.println(clientid);
				data = in.readLine();
				
				
				socket.close();
				
			} catch (IOException e) {
				ServerMain.addResult("Error!");
			} //try catch end
		} //run end
	} //Connecting class end
} //Server end
