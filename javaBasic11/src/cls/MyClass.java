package cls;

public class MyClass {
	
	private int number;
	private String name;
	private double height;
	
	public MyClass() {
		System.out.println("MyClass MyClass()");
		number = 1;
		name = "aaa";
		height = 0.0;
	}
	
	public MyClass(int number, String name) {
		this(); // super
		
		this.number = number;
		this.name = name;
		System.out.println("MyClass(int number, String name)");
	}

	public MyClass(int number, String name, double height) {
		this(number, name); // MyClass(int number, String name) 이 생성자를 의미, 항상 맨 위에서 호출 해야 함.
		
		this.number = number;
		this.name = name;
		this.height = height;
		
		System.out.println("MyClass(int number, String name, double height)");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	/*
	 * this : 자기참조 -> class 생성 시 heap 영역의 저장되는 영역의 주소
	 */
	
	public MyClass getThis() {
		return this;
	}
	
	public void func() {
		// 자기 클래스 내에서 필드 접근 시 this 생략 가능
		height = 180.0;
		getThis();
	}
	
	public void function(int number) {
		this.number = number;
	}

}
