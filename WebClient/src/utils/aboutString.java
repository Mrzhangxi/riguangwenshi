package utils;

public interface aboutString {
	/**
	 * 解析从单片机中传过来的字符串，包含空气温度、空气湿度、土壤湿度三个信息，分别以#、@、$区别。
	 * @author MrZhangxi
	 * @param datas
	 * 			代表从单片机拿到的字符数组
	 * @param elements
				解析后将数据回传给elements
	 * @return 返回一个字符串，代表从单片机中解析出来的空气温度、空气湿度、土壤湿度三个参数
	 * @
	 * */
	
	public String[] resolveStringFromClient(String datas, String[] elements);
}
