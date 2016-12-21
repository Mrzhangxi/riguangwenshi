package utils;

import java.sql.Connection;

public interface aboutDatabase {
	/**
	 * ��ʼ��JDBC����������
	 * @author MrZhangxi
	 * */
	public void intiDatabase();
	/**
	 * ͨ����������ݿ�URL�����ݿ��û��������ݿ����������һ�����ݿ����ӣ��Ժ����ʹ�����ӳ����Ż���
	 * @param url ���ݿ�URL
	 * @param user ���ݿ���û���
	 * @param pass ���ݿ������
	 * @return ����һ�����ݿ����ӣ�ͨ��������ӿ��Զ���Ӧ�����ݿ���в���
	 */
	public Connection getconn(String url, String user, String pass);
	/**
	 * ��ʱ�Եĺ�������У��Mac����Ŀǰ��������Ĭ�ϵ�һ������
	 * �Ѿ����Mac
	 * @param Mac Mac��ַ
	 * @param AirHumidity ����ʪ��
	 * @param AirTemp �����¶�
	 * @param SoilHumidity ����ʪ��
	 * @param createtime ����ʱ��
	 * @return
	 */
	public int tempInsertelement(String Mac, double AirHumidity, double AirTemp, double SoilHumidity, String createtime);
	
}
