package overridecls;

public class ChildOne extends SuperClass {

	public void method() {
		System.out.println("ChildOne Override method()");
	}
	
	public void childOneMethod() { // 오버라이드 한 메소드 아님
		System.out.println("childOneMethod()");
	}
}
