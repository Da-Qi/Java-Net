package Net_04;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/*
 * 
 * TCP��
 * A���������Ͷ˵�Socket����
 * B����ȡ�������д����
 * C���ͷ���Դ
 * 
 */
public class ClientDemo {
	public static void main(String[] args) throws IOException {
		//�������Ͷ˵�Socket����
		//public Socket(String host,int port)
		//public Socket(InetAddress address,int port)
		//Socket s = new Socket(InetAddress.getByName("192.168.1.3"),8888);
		Socket s = new Socket("192.168.1.3",8888);
		
		//public OutputStream getOutputStream()
		OutputStream os = s.getOutputStream();
		os.write("hello tcp ������".getBytes());
		
		//�ͷ���Դ
		s.close();

	}
}
