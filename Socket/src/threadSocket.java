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
			String element[] = new String[4];//长度为4的一维数组，分别保存空气温度，空气湿度，土壤温度，Mac地址
			while((readlength=is.read(buff)) > 0)	{//这个地方存在隐患，如果传过来的数据大于2014byte就会出现数据丢失的情况
				str = new String(buff,0,readlength);//在没有断开输入流之前，这个循环会一直存在
				System.out.println(str);
				element = asi.resolveStringFromClient(str, element);
				if(element==null){
					System.out.println("I'm server, Client’s datas not resolves");
				} else{
					System.out.println("I'm server, Client said : " + "Mas:" + element[3] + " AirHumidity:" + element[0] + " AirTemp:" + element[1] + " SoilHumidity:" + element[2]);
				}
//				String time = Server.getStringTime();
				try {
					sleep(3000);
					os.write(("M").getBytes());
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} finally {
					os.flush();
					
				}
			}
		
		is.close();
		os.close();
//		socket.shutdownOutput();
		socket.close();
		System.out.println("关闭响应资源");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
}
