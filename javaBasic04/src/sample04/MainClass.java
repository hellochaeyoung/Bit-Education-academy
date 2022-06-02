package sample04;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * 
		 * Wrapper class
		 * 일반 자료형을 클래스화한 것
		 * 
		 * 일반 자료형		wrapper class
		 * boolean		Boolean
		 * byte			Byte
		 * short		Short
		 * int			Integer		--->
		 * long			Long
		 * float		Float
		 * double		Double		--->
		 * char			Character
		 * char[]		String		--->
		 * 
		 */
		
		
		int i = 123;
		Integer in = 234;
		Integer cin = new Integer(345);
		
		System.out.println(cin);
		
		double d = 123.456;
		Double dd = 1234.5678;
		
		System.out.println(dd);
		
		// Integer, Double
		// String
		
		// 문자열 -> 숫자
		String str = "1234";
		int num = Integer.parseInt(str);
		System.out.println("num = " + num);
		
		str = "234.5678";
		double dnum = Double.parseDouble(str);
		System.out.println(dnum);
		
		// 숫자 -> 문자열
		Integer num1 = 234;
		//String str1 = num1 + "";
		String str1 = num1.toString();
		System.out.println(str1);
		
		double dd2 = 234.5678;
		String str2 = dd2 + "";
		System.out.println(str2);
		
		/*
		 * String 클래스
		 * 
		 * 문자열 저장, 편집, 정보 취득
		 */
		
		String str3 = "";
		
		//System.out.println("str3 = " + str3);
		
		str3 = "안녕하세요";
		
		String str4 = new String("hello");
		String str5 = str3 + str4;
		
		System.out.println(str5);
		
		str3 = str3.concat(str4);
		System.out.println(str3);
		
		// equals : 비교 함수
		String str6 = "world";
		String str7 = "worl";
		
		str7 = str7 + "d";
		
		System.out.println(str6 == str7); // 초기값으로 비교하기 때문에 false 출력
		System.out.println(str6.equals(str7));
		
		// 문자 위치
		// indexOf, lastIndexOf
		String str8 = "abcabcabc";
		int index = str8.indexOf("c");
		System.out.println("index = " + index);
		
		int index2 = str8.lastIndexOf("c");
		System.out.println("index = " + index2);
		
		// 문자열의 길이
		// length(), 배열에서는 length
		System.out.println(str8.length());
		
		// 수정 replace
		String str9 = "A*B*C*D";
		String replaceStr = str9.replace("*", "-");
		System.out.println(replaceStr);
		
		// 문자열 자르기
		// split => tokenNizer
		
		/*
		 * 
		 * 홍길동-24-2001/03/16-서울시
		 * 성춘향-16-2011/07/26-남원시
		 * 
		 * 홍길동			--> 파싱의 필요성 느낌 -> XML -> JSON
		 * 24
		 * 2001/03/16
		 * 서울시
		 */
		
		String str10 = "홍길동-24-2001/03/16-서울시";
		
		String[] split = str10.split("-");
		System.out.println(split[0]);
		System.out.println(split[1]);
		System.out.println(split[2]);
		System.out.println(split[3]);
		
		// 문자열을 자른다
		// 범위를 기준으로 -> substring()
		String subStr = str10.substring(4);
		System.out.println(subStr);
		
		subStr = str10.substring(4,6);
		System.out.println(subStr);
		
		// 앞 뒤 공백문자 삭제
		// trim()
		String str11 = " java   java   java    ";
		System.out.println(str11.trim());
		
		// index 숫자 입력하면 문자 리턴
		// charAt
		String str12 = "가나다라마";
		char c = str12.charAt(2);
		System.out.println(c);
		
		// 문자열 탐색
		// contains
		String str13 = "서울시 마포구 서교동";
		boolean b = str13.contains("서교");
		System.out.println(b);
		
	}

}
