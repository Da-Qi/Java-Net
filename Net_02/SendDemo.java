package Net_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/*
 * �������Լ���¼�룺
 * ���̿������ݴ��ͽ���
 */

public class SendDemo {
	public static void main(String[] args) throws IOException {
		//�������Ͷ˵�Socket����
		DatagramSocket ds = new  DatagramSocket();
		
		//��װ����¼������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = br.readLine())!= null) {
			if("886".equals(line)) {
				break;
			}
			//�������ݲ����
			byte[] bys = line.getBytes();
			DatagramPacket dp = new DatagramPacket(bys,bys.length,
					InetAddress.getByName("192.168.1.3"),18585);
			
			//��������
			ds.send(dp);
		}
		
		
		//�ͷ���Դ
		ds.close();
	}
}
