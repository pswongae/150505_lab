package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadHandler implements Runnable{
	
	private Socket clientSocket;
	private int visitCounter;

	public ThreadHandler(Socket clientSocket, int visitCounter) {
		// TODO Auto-generated constructor stub
		this.clientSocket = clientSocket;
		this.visitCounter = visitCounter;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			String clientInput = "";
			while ((clientInput = in.readLine()) != null){
				switch (clientInput){
					case "visitor":
						out.println("You're the " + visitCounter + " visitor today");
						break;
					case "quit":
						break;
					default:
						out.println("echo: " + clientInput);
						break;
				}
			}
			in.close();
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
