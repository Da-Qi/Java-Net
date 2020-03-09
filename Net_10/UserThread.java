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
			//封装通道读对象
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			
			String newname = System.currentTimeMillis()+".java";
			//封装写对象
			BufferedWriter bw = new BufferedWriter(new FileWriter(newname));	
			
			
			
			String line = null;
			while((line = br.readLine())!=null) {
				bw.write(line);
				bw.newLine();
				bw.flush();
			}
			
			//给出反馈
			BufferedWriter bwserver = new BufferedWriter(
					new OutputStreamWriter(s.getOutputStream()));
			
			bwserver.write("文件上传成功");
			bwserver.newLine();
			bwserver.flush();
			
			
			bw.close();
			s.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
