package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket sSocket; // empty the new server's client
	Socket client; // port
	Thread newClient;

	BufferedReader read;
	BufferedReader input;
	PrintWriter output;

	public void start(int port) {
		try {
			sSocket = new ServerSocket(port); // set port number
			ServerMain.addResult("Server: " + InetAddress.getLocalHost().getHostAddress());
			newClient = new Thread(new startClient()); // new thread for server
			newClient.start(); // start thread
		} catch (IOException e) {
			ServerMain.addResult("Server is already opened");
			e.printStackTrace();
		} finally {
			try {
				if (read != null)
					sSocket.close();
				if (client != null)
					client.close();
			} catch (IOException e) {
				ServerMain.addResult("Error in Server");
				e.printStackTrace();
			} // try catch end
		} // try catch end

	} // start end

	void getMessage() {
		while (true) {
			try {
				ServerMain.addResult("New Message: " + read.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private class startClient implements Runnable {
		@Override
		public void run() {
			try {
				client = sSocket.accept(); // accept
				ServerMain.addResult("Connecting " + client.getInetAddress() + " at port " + client.getPort());
				read = new BufferedReader(new InputStreamReader(client.getInputStream())); // read client's message

				ServerMain.addResult("Message from client: " + read.readLine());
				client.close();// close client
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
} // Server end
