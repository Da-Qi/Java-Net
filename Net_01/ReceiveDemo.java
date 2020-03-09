package Net_01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo {
	public static void main(String[] args) throws IOException {
		// �������ն˵�Socket����
		DatagramSocket ds = new DatagramSocket(18585);

		// ����һ������
		byte[] bys = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bys, bys.length);

		// ��������
		ds.receive(dp);

		// ��������
		String ip = dp.getAddress().getHostAddress();
		String s = new String(dp.getData(), 0, dp.getLength());
		System.out.println("from " + ip + " data is " + s);
		
		//�ͷ���Դ
		ds.close();

	}
}
