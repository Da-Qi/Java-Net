package Net_03;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * 通过多线程改进刚才的聊天程序，这样我就看实现在一个窗口
 * 发送和接手数据
 */
public class ChatRoom {
	public static void main(String[] args) throws IOException {
		DatagramSocket dsSend = new DatagramSocket();
		DatagramSocket dsReceive = new DatagramSocket(12306);

		SendThread st = new SendThread(dsSend);
		ReceiveThread rt = new ReceiveThread(dsReceive);

		Thread t1 = new Thread(st);
		Thread t2 = new Thread(rt);

		t1.start();
		t2.start();
	}
}
