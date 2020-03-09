package Net_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*
 * 客户端传输文本文件，服务器传输文本文件
 */
public class UploadClient {
	public static void main(String[] args) throws IOException {
		//创建客户端Socket对象
		Socket s = new Socket("192.168.1.3",11111);
		
		//封装文本文件
		BufferedReader br = new BufferedReader(
				new FileReader("ChatRoom.java"));
		
		//封装网络通道
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(s.getOutputStream()));
		
		String line = null;
		while((line = br.readLine())!= null) {
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		//传输完毕后发送提示
		s.shutdownOutput();
		
		//接受反馈
		BufferedReader brclient = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		String client =brclient.readLine();
		System.out.println(client);
		
		s.close();
		br.close();
	}
}
