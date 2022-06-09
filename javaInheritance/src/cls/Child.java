package cls;

public class Child extends Parent {
	
	private double height;
	
	public Child() {
		super("Aaa");
		System.out.println("Child()");
	}
	
	

	public Child(String name, double height, int age) {
		super(name, age);
		this.height = height;
	}



	public void func() {
		System.out.println("Child func()");
		
		age = 25; // protected라면 자식 클래스에서 접근 가능!
	}



	@Override
	public String toString() {
		return "Child [height=" + height + "]";
	}
	
	public void print() {
		System.out.println(super.toString());
		System.out.println(toString());
	}
	
	
}
