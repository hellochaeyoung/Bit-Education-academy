package cls;

public class Player {
	
	private int number;
	private String name;
	private int age;
	private double height;
	
	public Player(int number, String name, int age, double height) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
		this.height = height;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public void update(int num, String data) {
		
		switch(num) {
			case 1 : {
				this.name = data;
				break;
			}
			case 2 : {
				this.age = Integer.parseInt(data);
				break;
			}
			case 3 : {
				this.height = Double.parseDouble(data);
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "Player [number=" + number + ", name=" + name + ", age=" + age + ", height=" + height + "]";
	}
	
}
