import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import utilsIpml.aboutStringIpml;

public class threadSocket extends Thread {
	private Socket socket;
	public threadSocket(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		System.out.println(Thread.currentThread().getName());
		try {
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();	
			aboutStringIpml asi = new aboutStringIpml();
			byte buff[] = new byte[1024];
			int readlength = 0;
			String str = null;
			String element[] = new String[4];//����Ϊ4��һά���飬�ֱ𱣴�����¶ȣ�����ʪ�ȣ������¶ȣ�Mac��ַ
			while((readlength=is.read(buff)) > 0)	{//����ط�������������������������ݴ���2014byte�ͻ�������ݶ�ʧ�����
				str = new String(buff,0,readlength);//��û�жϿ�������֮ǰ�����ѭ����һֱ����
				System.out.println(str);
				element = asi.resolveStringFromClient(str, element);
				if(element==null){
					System.out.println("I'm server, Client��s datas not resolves");
				} else{
					System.out.println("I'm server, Client said : " + "Mas:" + element[3] + " AirHumidity:" + element[0] + " AirTemp:" + element[1] + " SoilHumidity:" + element[2]);
				}
//				String time = Server.getStringTime();
				try {
					sleep(3000);
					os.write(("M").getBytes());
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} finally {
					os.flush();
					
				}
			}
		
		is.close();
		os.close();
//		socket.shutdownOutput();
		socket.close();
		System.out.println("�ر���Ӧ��Դ");
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
}
