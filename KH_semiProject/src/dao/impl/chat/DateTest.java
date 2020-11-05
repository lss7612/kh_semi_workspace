package dao.impl.chat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	
	public static void main(String[] args) {
		
		Date time = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		
		String time2 = sdf.format(time);
		
		System.out.println("time2 : "+time2);
		System.out.println("년/월/일 : "+time2.substring(0,10));
		System.out.println("년/월 : "+time2.substring(0,7));
		System.out.println("일 : "+time2.substring(8,10));
		System.out.println("시각 : "+time2.substring(11,13));
		System.out.println("분 : "+time2.substring(14,16));
		
	}
}
