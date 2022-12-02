package Main;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class Client extends ClientMain implements Runnable {
	/**
	 * default serial number
	 */
	private static final long serialVersionUID = 1L;
	DataInputStream input;
	PrintStream output;
	Socket cSocket;
	
	

	void start(int port, String serverName) {
		try {
			cSocket = new Socket(serverName, port);
			input = new DataInputStream(cSocket.getInputStream());
			output = new PrintStream(cSocket.getOutputStream(), true);

			ArrayList<String> player = new ArrayList<>();
			
			Design d = new Design();
			player.add(username);
			player.add(String.valueOf(d.point));
			player.add(String.valueOf(d.time));

			try {
				output.println("Player: " + player.get(0) + "points: " + player.get(1) + "time: " + player.get(2));
				addResult(output.toString());
				output.flush();
				cSocket.close(); // close socket
			} catch (IOException e) {
				ServerMain.addResult("Error");
			} // try catch end
		} catch (IOException e) {
			ServerMain.addResult("Connection Error");
		} // try catch end
	} // start end

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
} // Client class end
