package Net_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*
 * �ͻ����ı��ļ������������������̨
 */
public class ClientDemo {
	public static void main(String[] args) throws IOException {
		//��װSocket����
		Socket s =new Socket("192.168.1.3",13757);
		
		//��װ�ı��ļ�����
		BufferedReader br = new BufferedReader(
				new FileReader("a.txt"));
		
		//��װͨ��������
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(s.getOutputStream()));
		
		String line = null;
		while((line = br.readLine())!= null) {
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		s.close();
		br.close();
	}
}
