package com.pkq.close;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TcpClient{
	static int TIMEOUT = 5000;
	int maxLenRecvBuffer = 10240;  //最大接收数据大小，最大为1也50(pageSize)条策略

	public String sendAndReceive(String host, int port, String strSend)
			throws Exception {
		int nRead = 0;
		DataOutputStream dos = null;
		InputStream in = null;
		InetSocketAddress addr = new InetSocketAddress( host, port ) ;
		Socket clientSocket = new Socket();
		clientSocket.connect( addr , TIMEOUT );
		dos = new DataOutputStream( clientSocket.getOutputStream() );
		dos.write( strSend.getBytes() );
		dos.flush();
		byte[] buffer = new byte[maxLenRecvBuffer];
		in = clientSocket.getInputStream();
		nRead = in.read(buffer, 0, maxLenRecvBuffer);
		String strRecv = new String(buffer, 0, nRead);
		System.out.println("UdpClient recv:" + strRecv);
		
		clientSocket.close();
		return strRecv;
	}

}
