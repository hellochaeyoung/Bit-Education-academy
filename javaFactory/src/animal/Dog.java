package animal;

public class Dog implements Animal {

	@Override
	public void printDescript() {
		System.out.println("강아지 입니다.");

	}
	
	public void dogMethod() {
		System.out.println("멍멍");
	}

}
