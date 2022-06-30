package cls;

import java.util.Scanner;

public class Pitcher extends Player {
	
	private int win;
	private int lose;
	private double rate;
	
	public Pitcher(int number, String name, int age, double height, int win, int lose, double rate) {
		super(number, name, age, height);
		this.win = win;
		this.lose = lose;
		this.rate = rate;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public void update(int num, String data) {
		super.update(num, data);
		
		switch(num) {
			case 4 : {
				this.win = Integer.parseInt(data);
				break;
			}
			case 5 : {
				this.lose = Integer.parseInt(data);
				break;
			}
			case 6 : {
				this.rate = Double.parseDouble(data);
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "Pitcher " + super.toString() + " [win=" + win + ", lose=" + lose + ", rate=" + rate + "]";
	}
	
	
	

}
