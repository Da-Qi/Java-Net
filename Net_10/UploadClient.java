package Net_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*
 * �ͻ��˴����ı��ļ��������������ı��ļ�
 */
public class UploadClient {
	public static void main(String[] args) throws IOException {
		//�����ͻ���Socket����
		Socket s = new Socket("192.168.1.3",11111);
		
		//��װ�ı��ļ�
		BufferedReader br = new BufferedReader(
				new FileReader("ChatRoom.java"));
		
		//��װ����ͨ��
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(s.getOutputStream()));
		
		String line = null;
		while((line = br.readLine())!= null) {
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		//������Ϻ�����ʾ
		s.shutdownOutput();
		
		//���ܷ���
		BufferedReader brclient = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		String client =brclient.readLine();
		System.out.println(client);
		
		s.close();
		br.close();
	}
}
