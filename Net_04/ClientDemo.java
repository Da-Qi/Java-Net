package Net_04;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/*
 * 
 * TCP：
 * A：创建发送端的Socket对象
 * B：获取输出流，写数据
 * C：释放资源
 * 
 */
public class ClientDemo {
	public static void main(String[] args) throws IOException {
		//创建发送端的Socket对象
		//public Socket(String host,int port)
		//public Socket(InetAddress address,int port)
		//Socket s = new Socket(InetAddress.getByName("192.168.1.3"),8888);
		Socket s = new Socket("192.168.1.3",8888);
		
		//public OutputStream getOutputStream()
		OutputStream os = s.getOutputStream();
		os.write("hello tcp 我来了".getBytes());
		
		//释放资源
		s.close();

	}
}
