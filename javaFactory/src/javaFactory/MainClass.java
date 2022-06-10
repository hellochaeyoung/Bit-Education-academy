package javaFactory;

import java.util.ArrayList;
import java.util.List;

import animal.Animal;
import animal.Cat;
import animal.Cow;
import animal.Dog;
import factory.AnimalFactory;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * Factory : object 공장
		 * 			 원하는 object를 생성하기 위한 pattern
		 * 
		 * animal - interface
		 * 
		 * cat, dog, cow - class 
		 * 
		 * Factory
		 */
		
		List<Animal> list = new ArrayList<>();
		
		Animal animal1 = AnimalFactory.create("고양이");
		list.add(animal1);
		
		animal1 = AnimalFactory.create("황소");
		list.add(animal1);
		
		animal1 = AnimalFactory.create("강아지");
		list.add(animal1);
		
		animal1 = AnimalFactory.create("황소");
		list.add(animal1);
		
		for(Animal a : list) {
			a.printDescript();
			
			if(a instanceof Cat) {
				((Cat) a).catMethod();
			}else if(a instanceof Dog) {
				((Dog)a).dogMethod();
			}else if(a instanceof Cow) {
				((Cow)a).cowMethod();
			}
		}
		
		/*
		animal1.printDescript();
		Cat cat = (Cat)animal1;
		cat.catMethod();
		*/
		
		
	}

}
