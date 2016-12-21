package utils;

import java.util.Date;

public interface aboutString {
	/**
	 * 解析从单片机中传过来的字符串，包含空气温度、空气湿度、土壤湿度三个信息，分别以#、@、$区别。
	 * @author MrZhangxi
	 * @param datas
	 * 			代表从单片机拿到的字符数组
	 * @param elements
				解析后将数据回传给elements
	 * @param cur_time
	 * 			传入一个Date变量，对应一个连接，在该方法中赋值当前的时间，将改时间转换为simpledate类型保存在数据库（重复使用该对象）
	 * @return 返回一个字符串，代表从单片机中解析出来的空气温度、空气湿度、土壤湿度三个参数
	 * */
	
	public String[] resolveStringFromClient(String datas, String[] elements, Date cur_time);
}
