package Net_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ���������������̨
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException {
		// ��װ������Socket����
		ServerSocket ss = new ServerSocket(13757);

		// �����ͻ���
		Socket s = ss.accept();

		// ��װͨ��������
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;
		while((line = br.readLine())!=null) {
			System.out.println(line);
		}
		
		s.close();
	}
}
