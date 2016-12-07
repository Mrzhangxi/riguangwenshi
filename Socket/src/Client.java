import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
//客户端
	
	public static void main(String[] args) {
		try {
			//1.创建一个socket，指定服务器地址和端口号
			Socket socket = new Socket("localhost", 8888);
			//2.获取输出流，向服务器端发送信息
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			os.write("你好".getBytes());;
			os.flush();
			byte buff[] = new byte[1024];
			int readlength = 0;
			while((readlength=is.read(buff)) > 0)	{
				String str = new String(buff,0,readlength);
				System.out.println("I'm Client, Server said : "+str);
			}
			socket.shutdownOutput();
			is.close();
			os.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
