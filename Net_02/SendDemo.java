package Net_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/*
 * 数据来自键盘录入：
 * 键盘控制数据传送结束
 */

public class SendDemo {
	public static void main(String[] args) throws IOException {
		//创建发送端的Socket对象
		DatagramSocket ds = new  DatagramSocket();
		
		//封装键盘录入数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = br.readLine())!= null) {
			if("886".equals(line)) {
				break;
			}
			//创建数据并打包
			byte[] bys = line.getBytes();
			DatagramPacket dp = new DatagramPacket(bys,bys.length,
					InetAddress.getByName("192.168.1.3"),18585);
			
			//发送数据
			ds.send(dp);
		}
		
		
		//释放资源
		ds.close();
	}
}
