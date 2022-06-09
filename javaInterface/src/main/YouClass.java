package main;

public class YouClass implements MyInterface, YouInterface { // 다중 상속

	@Override
	public void func(String str) {
		System.out.println("YouClass func(String str)");
		
	}

	@Override
	public void method(int n) {
		System.out.println("YouClass method(int n)");
		
	}

}
