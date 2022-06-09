package cls;

public class Parent {
	
	private String name;
	protected int age; // 자식 클래스에서는 접근 허용한다, 외부에서 차단
	
	/*
	 * public Parent() { System.out.println("Parent()"); }
	 * 
	 */
	
	

	public void parentMethod() {
		System.out.println("Parent parentMethod()");
	}

	public Parent(String name) {
		this.name = name;
		
		System.out.println("Parent(String name)");
	}

	public Parent(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Parent [name=" + name + ", age=" + age + "]";
	}
	
	

}
