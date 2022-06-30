package main;

import cls.NameCard;
import cls.PrintEmailCard;
import cls.PrintNameCard;
import cls.PrintPhoneCard;

public class MainClass {

	public static void main(String[] args) {
		
		NameCard ncard = new NameCard("aaa", "233", "aaa@gmail.com");
		
		ncard.setPrintNameCard(new PrintEmailCard());
		ncard.print();
		
		

	}

}
