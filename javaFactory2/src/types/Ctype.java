package types;

import bomb.Bomb;
import bomb.C4;
import weapon.Sword;
import weapon.Weapon;

public class Ctype implements AbstractItem {

	@Override
	public Weapon createWeapon() {
		// TODO Auto-generated method stub
		return new Sword();
	}

	@Override
	public Bomb createBomb() {
		// TODO Auto-generated method stub
		return new C4();
	}

}
