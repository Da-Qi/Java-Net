package Net_01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo {
	public static void main(String[] args) throws IOException {
		// 创建接收端的Socket对象
		DatagramSocket ds = new DatagramSocket(18585);

		// 创建一个包裹
		byte[] bys = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bys, bys.length);

		// 接受数据
		ds.receive(dp);

		// 解析数据
		String ip = dp.getAddress().getHostAddress();
		String s = new String(dp.getData(), 0, dp.getLength());
		System.out.println("from " + ip + " data is " + s);
		
		//释放资源
		ds.close();

	}
}
