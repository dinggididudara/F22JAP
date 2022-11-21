package Main;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	DataInputStream input;
	PrintStream output;
	Socket cSocket;
	void start(int port) {
		try {
			cSocket = new Socket(InetAddress.getLocalHost().getHostAddress(), port);
			input = new DataInputStream(cSocket.getInputStream());
			output = new PrintStream(cSocket.getOutputStream());
			
			String message = input.readLine();
			String userInput;
			String serverData;
			
			DataInputStream userDataInputStream = new DataInputStream(System.in);
			try {
				userInput = userDataInputStream.readLine();
				output.println(userInput);
				ServerMain.addResult(output.toString());
				output.flush();
				cSocket.close(); //close socket
			} catch (IOException e) {
				ServerMain.addResult("Error");
			} //try catch end
		} catch (IOException e) {
			ServerMain.addResult("Error");
		} //try catch end
	} //start end
} //Client class end
