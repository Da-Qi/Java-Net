package Net_04;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 
 * TCP��
 * A���������ն˵�Socket����
 * B�������ͻ��˽��ա�����һ����Ӧ��Socket����
 * C����ȡ����������ȡ������ʾ�ڿ���̨
 * D���ͷ���Դ
 * 
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException {
		// public ServerSocket(int port)
		ServerSocket ss = new ServerSocket(8888);

		// �����ͻ��˽��ա�����һ����Ӧ��Socket����
		// public Socket accept() ���������ܵ����׽��ֵ����ӡ�
		// �˷��������Ӵ���֮ǰһֱ����
		Socket s = ss.accept();

		// ��ȡ����������ȡ������ʾ�ڿ���̨
		InputStream is = s.getInputStream();

		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = is.read(bys)) != -1) {
			String str = new String(bys, 0, len);
			String ip = s.getInetAddress().getHostAddress();
			System.out.println(ip + ":" + str);
		}

		// �ͷ�
		s.close();
		// ���������ر�
	}
}
