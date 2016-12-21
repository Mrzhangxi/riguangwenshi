package utils;

import java.sql.Connection;

public interface aboutDatabase {
	/**
	 * 初始化JDBC，加载驱动
	 * @author MrZhangxi
	 * */
	public void intiDatabase();
	/**
	 * 通过输入的数据库URL，数据库用户名，数据库密码来获得一个数据库连接（以后可以使用连接池来优化）
	 * @param url 数据库URL
	 * @param user 数据库的用户名
	 * @param pass 数据库的密码
	 * @return 返回一个数据库连接，通过这个链接可以对相应的数据库进行操作
	 */
	public Connection getconn(String url, String user, String pass);
	/**
	 * 临时性的函数，不校验Mac，将目前所有链接默认到一个表中
	 * 已经添加Mac
	 * @param Mac Mac地址
	 * @param AirHumidity 空气湿度
	 * @param AirTemp 空气温度
	 * @param SoilHumidity 土壤湿度
	 * @param createtime 插入时间
	 * @return
	 */
	public int tempInsertelement(String Mac, double AirHumidity, double AirTemp, double SoilHumidity, String createtime);
	
}
