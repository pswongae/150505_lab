package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {

	private static int visitCounter = 0;
	public static final int PORT = 3021;
	
	public static void main(String[] args){
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			while (true){
				Socket clientSocket = serverSocket.accept();
				ThreadHandler threadHandler = new ThreadHandler(clientSocket, ++visitCounter);
				Thread thread = new Thread(threadHandler);
				thread.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
