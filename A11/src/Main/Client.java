package Main;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	InputStream input;
	Socket cSocket;
	void start(int port) {
		try {
			cSocket = new Socket(InetAddress.getLocalHost().getHostAddress(), port);
			input = cSocket.getInputStream();
			
			byte[] buffer = new byte[100];
			input.read(buffer);
			
			
			cSocket.close(); //close socket
		} catch (IOException e) {
			
		} //try catch end
	} //start end
} //Client class end
