import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
//�ͻ���
	
	public static void main(String[] args) {
		try {
			//1.����һ��socket��ָ����������ַ�Ͷ˿ں�
			Socket socket = new Socket("localhost", 8888);
			//2.��ȡ���������������˷�����Ϣ
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			os.write("���".getBytes());;
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
