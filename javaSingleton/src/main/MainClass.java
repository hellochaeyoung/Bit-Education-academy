package main;

import cls.HeClass;
import cls.MyClass;
import cls.YouClass;
import single.SingletonClass;

public class MainClass {

	public static void main(String[] args) {
		
		MyClass mycls = new MyClass(123);
		YouClass youcls = new YouClass();
		/*
		 * int n = mycls.getNumber(); youcls.setTag(n);
		 */
		
		System.out.println(youcls.toString());
		
		System.out.println(SingletonClass.getInstance());
		System.out.println(SingletonClass.getInstance());
		System.out.println(SingletonClass.getInstance());
		
		mycls.method();
		youcls.func();
		
		System.out.println(youcls.toString());
		
		HeClass hecls = new HeClass();
		hecls.proc();
		
		System.out.println(hecls.toString());

	}

}
