package main;

import java.util.Scanner;

public class Dice {

	int number;
	
	public void setNumber() {
		number = (int)(Math.random() * 6) + 1;
	}
	
	public int getNumber() {
		return number;
	}
	
}
