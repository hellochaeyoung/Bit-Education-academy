package main;

import java.util.Scanner;

public class Game {
	
	Scanner sc = new Scanner(System.in);
	
	int coin = 20;
	int bet;
	int userNumber;
	
	Dice diceOne = new Dice();
	Dice diceTwo = new Dice();
	
	public void init() {
		diceOne.setNumber();
		diceTwo.setNumber();
		
		System.out.println(diceOne.getNumber() + " " + diceTwo.getNumber());
		
	}
	
	public void userInput() {
		
		//betting
		System.out.println("배팅 금액 = ");
		bet = sc.nextInt();
		
		coin -= bet;
		
		// 주사위의 합
		System.out.println("두 주사위의 합 = ");
		userNumber = sc.nextInt();
		
	}
	
	public void finding() {
		
		int diceNum1 = diceOne.getNumber();
		int diceNum2 = diceTwo.getNumber();
		
		int diceSum = diceNum1 + diceNum2;
		
		if(diceSum == userNumber) {
			
			if(diceSum == 3 || diceSum == 11) {
				bet *= 18;
			}else if(diceSum == 4 || diceSum == 10) {
				bet *= 12;
			}else if(diceSum == 5 || diceSum == 9) {
				bet *= 9;
			}else if(diceSum == 6 || diceSum == 8) {
				bet *= 7;
			}else if(diceSum == 7) {
				bet *= 6;
			}
			
			System.out.println("성공! 축하합니다");
			coin += bet;
			
		}else {
			System.out.println("실패, 다시 도전하세요");
		}
	}
	
	public void result() {
		System.out.println("주사위의 값 : " + diceOne.getNumber() + "," + diceTwo.getNumber());
		
		System.out.println("합계: " + diceOne.getNumber() + diceTwo.getNumber());
		System.out.println("현재 금액 : " + coin);
	}
	
	public void play() {
		
		while(true) {
			init();
			
			userInput();
			
			finding();
			
			result();
			
			System.out.println("play again(y/n)");
			String again = sc.next();
			
			if(again.equals("n") || again.equals("N")) {
				System.out.println("게임 종료");
				break;
			}
			
			System.out.println("다시 시작");
		}
	}

}
