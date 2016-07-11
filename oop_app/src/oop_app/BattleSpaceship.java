package oop_app;

public class BattleSpaceship extends Spaceship {

	private int armor;

	BattleSpaceship() {
		super(100, "unnamed", "blank", 1);
		this.setArmor(100);
	}

	BattleSpaceship(int life, int armor, String name, String color, int type) {
		super(life, name, color, type);
		this.setArmor(armor);
	}

	@Override
	public void heal() {
		// TODO Auto-generated method stub
		if (this.getLife() < 100) {
			this.setLife(getLife() + 30);
			if (this.getLife() > 100)
				this.setLife(this.getLife() - (this.getLife()) % 100);
		} else
			System.out.println("spaceship: " + this.getName() + " has full life");
	}

	public SimpleSpaceship attack(SimpleSpaceship ss) {

		System.out.println(this.getName() + " attacked " + ss.getName());
		ss.setLife(getLife() - 20);
		if (ss.getLife() <= 0) {
			System.out.println("spaceship: " + ss.getName() + " was destroyed");
			ss.setDistroyed(true);
		} else
			System.out.println("spaceship: " + ss.getName() + " has " + ss.getLife() + " life left");
		return ss;
	}

	public BattleSpaceship attack(BattleSpaceship bs) {

		System.out.println(this.getName() + " attacked " + bs.getName());

		if (bs.getArmor() <= 0) {
			bs.setLife(getLife() - 20);
			if (bs.getLife() <= 0) {
				System.out.println("spaceship: " + bs.getName() + " was destroyed");
				bs.setDistroyed(true);
			}
		} else {
			bs.setArmor(bs.getArmor() - 10);
			if (bs.getArmor() <= 0) {
				System.out.println("spaceship: " + bs.getName() + " was destroyed");
				bs.setDistroyed(true);
			}
		}
		return bs;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}
}
