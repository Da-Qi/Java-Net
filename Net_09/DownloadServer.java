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
		//封装服务器对象
		ServerSocket ss = new ServerSocket(11111);
		
		//创建监听对象
		Socket s = ss.accept();
		
		//封装通道读对象
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//封装写对象
		BufferedWriter bw = new BufferedWriter(new FileWriter("DownloadFile.txt"));	
		
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
	}
}
