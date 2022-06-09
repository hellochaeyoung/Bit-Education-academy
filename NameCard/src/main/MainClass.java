package main;

import cls.NameCard;
import cls.PrintNameCard;
import cls.PrintPhoneCard;

public class MainClass {

	public static void main(String[] args) {
		
		NameCard ncard = new NameCard("aaa", "123", "aaa@naver.com");
		
		ncard.setPrintNameCard(new PrintNameCard());
		ncard.print();
		
		ncard.setPrintPhoneCard(new PrintPhoneCard());
		ncard.printPhone();

	}

}
