package javaCalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * Calendar : 일정 관리, 인사 관리, 입사 정보
		 * 
		 * Date -> Javascript
		 * 
		 * Calendar -> java == Spring Framework
		 * 
		 * RESTful -> Spring Boot
		 * JavaScript -> Date
		 * 
		 */
		
		//Calendar cal = new GregorianCalendar();
		
		Calendar cal = Calendar.getInstance();
		
		// 오늘 날짜 취득
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; // 0 ~ 11
		int day = cal.get(Calendar.DATE);
		
		System.out.println(year + "/" + month + "/" + day);
		
		// 날짜 설정
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, 7); // 8월
		cal.set(Calendar.DATE, 15);
		
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1; // 0 ~ 11
		day = cal.get(Calendar.DATE);
		
		System.out.println(year + "/" + month + "/" + day);
		
		String ampm = cal.get(Calendar.AM_PM) == 0 ? "오전" : "오후";
		System.out.println(ampm);
		
		// 요일
		int weekday = cal.get(Calendar.DAY_OF_WEEK); // 1(일) ~ 7(토)
		
		switch(weekday) {
			case 1 :
				System.out.println("일요일");
				break;
			case 2 :
				System.out.println("월요일");
				break;
			case 3 :
				System.out.println("화요일");
				break;
			case 4 :
				System.out.println("수요일");
				break;
			case 5 :
				System.out.println("목요일");
				break;
			case 6 :
				System.out.println("금요일");
				break;
			case 7 :
				System.out.println("토요일");
				break;
		}

		
		// 오늘
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, 6);
		cal.set(Calendar.DATE, 8);
		
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(lastday);
		

		
	}
	

}
