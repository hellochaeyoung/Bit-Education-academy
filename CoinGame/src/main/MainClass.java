package main;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * 두 개의 주사위의 합을 맞추는 게임
		 * 
		 * 배팅 건 코인 개수에 따라 배수가 달라짐
		 * 
		 * 주사위 
		 * 		Random
		 * 				setter - Random
		 * 				getter
		 * 
		 * play
		 * 		init
		 * 		userInput
		 * 		finding
		 * 		result
		 */

		(new Game()).play();

	}

}
