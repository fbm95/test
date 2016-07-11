package oop_app;

public class SimpleSpaceship extends Spaceship {

	SimpleSpaceship() {
		super(100, "unnamed", "blank", 0);
	}

	SimpleSpaceship(int life, String name, String color, int type) {
		super(life, name, color, type);
	}

	@Override
	public void heal() {
		// TODO Auto-generated method stub
		if (this.getLife() < 100) {
			this.setLife(getLife() + 10);
			if (this.getLife() > 100)
				this.setLife(this.getLife() - (this.getLife()) % 100);
		} else
			System.out.println("spaceship: " + this.getName() + " has full life");
	}

}
