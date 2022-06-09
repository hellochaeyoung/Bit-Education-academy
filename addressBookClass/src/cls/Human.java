package cls;

public class Human {

	String name;
	int age;
	String phone;
	String address;
	String memo;
	
	public Human(String name, int age, String phone, String address, String memo) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.memo = memo;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(name).append("/").append(age).append("/").append(phone)
			.append("/").append(address).append("/").append(memo);
		
		return sb.toString();
	}
	
	public void print() {
		System.out.println("Human [name=" + name + ", age=" + age + ", phone=" + phone + ", address=" + address + ", memo=" + memo
				+ "]");
	}
	
	
}
