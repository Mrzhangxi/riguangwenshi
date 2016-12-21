package utilsIpml;

import java.text.SimpleDateFormat;
import java.util.Date;

import utils.aboutString;

public class aboutStringIpml implements aboutString{

	public String[] resolveStringFromClient(String datas, String[] element, Date cur_time) {
		if(datas.contains("@") && datas.contains("#") && datas.contains("$")/* && datas.length() == 10 && datas.length() == 11*/){
			String AirHumidity = datas.substring(1+17, 3+17);//加的17位是后边添加的Mac地址
			System.out.println(AirHumidity);
			if(AirHumidity == null && AirHumidity.length() <= 0){
				return null;
			}
			System.out.println(AirHumidity);
			element[0] = AirHumidity;
			
			String AirTemp = datas.substring(4+17,8+17);
			System.out.println(AirTemp);
			if(AirTemp == null && AirTemp.length() <= 0){
				return null;
			}
			element[1] = AirTemp;
			
			String SoilHumidity = datas.substring(9+17);
			System.out.println(SoilHumidity);
			if(SoilHumidity == null && SoilHumidity.length() <= 0){
				return null;
			}
			element[2] = SoilHumidity;
			
			String Mac = datas.substring(0,17);
			System.out.println(Mac);
			if(Mac == null && Mac.length() <= 0){
				return null;
			}
			element[3] = Mac;
		} else {
			return null;
		}
		cur_time = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		aboutDatabaseImpl ad = new aboutDatabaseImpl();
		ad.tempInsertelement(element[3], Double.parseDouble(element[1]), Double.parseDouble(element[0]), Double.parseDouble(element[2]), formatter.format(cur_time));
		return element;
	}

}
