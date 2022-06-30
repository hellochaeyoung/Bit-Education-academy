package factory;

import animal.Animal;
import animal.Cat;
import animal.Cow;
import animal.Dog;

public class AnimalFactory {
	
	public static Animal create(String animalName) {
		
		if(animalName.equals("")) {
			System.out.println("생성할 클래스가 없습니다.");
		}else if(animalName.equals("고양이")) {
			return new Cat();
		}else if(animalName.equals("강아지")) {
			return new Dog();
		}else if(animalName.equals("황소")) {
			return new Cow();
		}
		
		return null;
	}
}
