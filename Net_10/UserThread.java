package Net_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UserThread implements Runnable {

	private Socket s;

	public UserThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//��װͨ��������
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			
			String newname = System.currentTimeMillis()+".java";
			//��װд����
			BufferedWriter bw = new BufferedWriter(new FileWriter(newname));	
			
			
			
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
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
