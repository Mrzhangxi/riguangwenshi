package utilsIpml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.aboutDatabase;

public class aboutDatabaseImpl implements aboutDatabase{

	public void intiDatabase(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public Connection getconn(String url, String user, String pass) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}


	public int tempInsertelement(String Mac, double AirHumidity, double AirTemp,
			double SoilHumidity, String createtime) {
		String url = "jdbc:mysql://localhost:3306/servers";
		String user = "root";
		String pass = "123654147a";
		aboutDatabaseImpl ad = new aboutDatabaseImpl();
		ad.intiDatabase();
		Connection conn = ad.getconn(url, user, pass);
		try {
			PreparedStatement pstemt = conn.prepareStatement("insert into elementdata(mac,airtemp, airhum, soilhum, time) values (?,?,?,?,?)");
			pstemt.setString(1, Mac);
			pstemt.setDouble(2, AirTemp);
			pstemt.setDouble(3, AirHumidity);
			pstemt.setDouble(4, SoilHumidity);
			pstemt.setString(5, createtime);
			pstemt.execute();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}

}
