package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class BlogClient {
	
	public static final String IP = "127.0.0.1";
	public static final int PORT = 3021;
	
	public static void main(String[] args){
		try {
			
			Socket clientSocket = new Socket(IP, PORT);
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			out.println("Hello");
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
