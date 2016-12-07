import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Server {
	public static void main(String[] args) {
		try {
			boolean flag = true;
			ServerSocket ss = null;
			while(flag){
				ss = new ServerSocket(8888);
				System.out.println("Waiting Client......");
				Socket socket = ss.accept();
//				flag = true;
				Thread t = new threadSocket(socket);
				t.start();
//				flag = false;
				ss.close();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
//	public static String getStringTime (){
//		Date date = new Date();
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String time = format.format(date);
//		return time;
//	}

}
