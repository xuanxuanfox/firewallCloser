package com.pkq.close;

public class MainApp {

	
	public static void main(String[] args) {
		TcpClient client = new TcpClient();
		String host = "127.0.0.1";
		int port = 7709;
		String strSend = "please exit";
		try {
			client.sendAndReceive(host, port, strSend);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
