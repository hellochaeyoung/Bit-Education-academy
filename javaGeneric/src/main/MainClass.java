package main;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * 
		 * Generic : 자료형의 변수
		 * 			 같은 클래스에서 다양한 자료(Integer, String, Object ..)형을 사용하고 싶을 때 정의하는 요소
		 */
		
		Box<Integer> box = new Box<>(123); // 버전 업에 의해 뒤의 <>는 비워둬도 된다.
		System.out.println(box.getTemp() + 1);
		
		Box<String> sbox = new Box<>("aaa");
		System.out.println(sbox.getTemp() + 1);
		
		Boxmap<String, Integer> bmap = new Boxmap<>("asd", 234);
		System.out.println(bmap.getName());
		System.out.println(bmap.getValue());

	}

}

class Box<T> {
	
	T temp;

	public Box(T temp) {
		this.temp = temp;
	}

	public T getTemp() {
		return temp;
	}

	public void setTemp(T temp) {
		this.temp = temp;
	}		
}

 class Boxmap<K, V> {
	 
	K name;
	V value;
	 
	public Boxmap(K name, V value) {
		super();
		this.name = name;
		this.value = value;
	}

	public K getName() {
		return name;
	}

	public void setName(K name) {
		this.name = name;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	
	 
	 
 }