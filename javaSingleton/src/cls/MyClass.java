package cls;

import single.SingletonClass;

public class MyClass {
	
	private int number;

	public MyClass() {
		super();
	}

	public MyClass(int number) {
		super();
		this.number = number;
	}

	public void method() {
		
		SingletonClass sc  = SingletonClass.getInstance();
		sc.num = number;
	}
	

}
