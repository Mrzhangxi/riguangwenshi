package utils;

import java.util.Date;

public interface aboutString {
	/**
	 * �����ӵ�Ƭ���д��������ַ��������������¶ȡ�����ʪ�ȡ�����ʪ��������Ϣ���ֱ���#��@��$����
	 * @author MrZhangxi
	 * @param datas
	 * 			����ӵ�Ƭ���õ����ַ�����
	 * @param elements
				���������ݻش���elements
	 * @param cur_time
	 * 			����һ��Date��������Ӧһ�����ӣ��ڸ÷����и�ֵ��ǰ��ʱ�䣬����ʱ��ת��Ϊsimpledate���ͱ��������ݿ⣨�ظ�ʹ�øö���
	 * @return ����һ���ַ���������ӵ�Ƭ���н��������Ŀ����¶ȡ�����ʪ�ȡ�����ʪ����������
	 * */
	
	public String[] resolveStringFromClient(String datas, String[] elements, Date cur_time);
}
