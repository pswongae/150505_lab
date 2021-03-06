package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BlogClient {
	
	public static final String IP = "127.0.0.1";
	public static final int PORT = 3021;
	
	public static void main(String[] args){
		try {
			
			Socket clientSocket = new Socket(IP, PORT);
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String userInput, serverResponse;
			while (!(userInput = stdIn.readLine()).equals("quit")){
				out.println(userInput);
				serverResponse = in.readLine();
				System.out.println(serverResponse);
			}
			in.close();
			stdIn.close();
			out.close();
			clientSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
