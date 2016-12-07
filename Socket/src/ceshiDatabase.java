import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import utilsIpml.aboutDatabaseImpl;


public class ceshiDatabase {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/server";
		String user = "root";
		String pass = "";
		aboutDatabaseImpl ad = new aboutDatabaseImpl();
		ad.intiDatabase();
		Connection conn = ad.getconn(url, user, pass);
		Statement stmt = null;
		try {
			boolean flag ;
//			stmt = conn.createStatement();
////			flag = stmt.execute("insert into user (username, password, usercreatetime) values ('zhangxi2', '123456', '2016-9-21 11:03:32');");
//			flag = stmt.execute("insert into user (username, password, usercreatetime) values('gaojia', 'lygaojia','2016-2-12 11:32:2')");
//			System.out.println(flag);
////			PreparedStatement pstemt = conn.prepareStatement("insert into elementdata1 (mac, airtemp, airhum, soilhum) values (?,?,?,?)");
////			pstemt.setString(1, null);
////			pstemt.setDouble(2, 44.00);
////			pstemt.setDouble(3, 25.40);
////			pstemt.setDouble(4, 66.00);
////			pstemt.executeUpdate();
			PreparedStatement pstemt = conn.prepareStatement("insert into user (username, password, usercreatetime) values (?,?,?)");
			pstemt.setString(1, "zhangxi1");
			pstemt.setString(2, "123456");
			pstemt.setString(3, "2016-9-21 11:03:32");
			pstemt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
	}

}
