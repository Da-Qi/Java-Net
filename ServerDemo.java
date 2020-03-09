package Net_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 服务器输出到控制台
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException {
		// 封装服务器Socket对象
		ServerSocket ss = new ServerSocket(13757);

		// 监听客户端
		Socket s = ss.accept();

		// 封装通道流数据
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;
		while((line = br.readLine())!=null) {
			System.out.println(line);
		}
		
		s.close();
	}
}
