package Net_09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DownloadServer {
	public static void main(String[] args) throws IOException {
		//��װ����������
		ServerSocket ss = new ServerSocket(11111);
		
		//������������
		Socket s = ss.accept();
		
		//��װͨ��������
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//��װд����
		BufferedWriter bw = new BufferedWriter(new FileWriter("DownloadFile.txt"));	
		
		String line = null;
		while((line = br.readLine())!=null) {
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		//��������
		BufferedWriter bwserver = new BufferedWriter(
				new OutputStreamWriter(s.getOutputStream()));
		
		bwserver.write("�ļ��ϴ��ɹ�");
		bwserver.newLine();
		bwserver.flush();
		
		
		bw.close();
		s.close();
	}
}
