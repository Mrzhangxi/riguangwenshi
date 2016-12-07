package utils;

public interface aboutUser {
	/**
	 * 判断当前连接是否属于板子连接，如果是判断这块板子的数据属于哪个用户的哪台设备，返回对应的数据库表，
	 * 然后对该表进行数据的写入
	 * @param mac 传入该链接的Mac地址，通过mac地址来判断这块板子对应的数据表
	 * @return 返回该Mac地址对应的数据表的
	 */
	public String wConnOfDataTable(String mac);
}
