package single;

public class SingletonClass {
	
	private static SingletonClass sc = null;
	
	public int num;
	
	private SingletonClass() {
		
	}
	
	public static SingletonClass getInstance() { // static : 객체 생성 없이 어디서든 접근가능
		if(sc == null) {
			sc = new SingletonClass();
		}
		
		return sc;
	}

}
