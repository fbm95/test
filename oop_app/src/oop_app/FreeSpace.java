package oop_app;

import java.util.ArrayList;

public class FreeSpace implements Stocare {
	private ArrayList<Spaceship> free_space;

	FreeSpace() {
		this.free_space = new ArrayList<Spaceship>();
	}

	public void join_free_space(Spaceship s) {
		this.free_space.add(s);
		s.setSafe(false);
	}

	public void join_free_space(int i) {
		this.free_space.add(free_space.get(i));
		free_space.get(i).setSafe(false);
	}

	public Spaceship leave_free_space(int i) {
		free_space.get(i).setSafe(true);
		Spaceship aux = free_space.get(i);
		this.free_space.remove(free_space.get(i));
		return aux;
	}

	public Spaceship battle(int i1, int i2) throws CustomException{
		Spaceship sp = free_space.get(i2);
		if ((free_space.get(i1)).getType() == 1) {
			if ((free_space.get(i2)).getType() == 1)
				sp = ((BattleSpaceship) (free_space.get(i1))).attack((BattleSpaceship) free_space.get(i2));
			else
				sp = ((BattleSpaceship) (free_space.get(i1))).attack((SimpleSpaceship) free_space.get(i2));
		}
		else
			throw new CustomException("can't attack same faction");
		return sp;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Navele spatiale din spatiul liber:");
		for (int i = 0; i < free_space.size(); i++)
			if (free_space.get(i).getType() == 0)
				System.out.println("index: " + i + " name: " + (free_space.get(i)).getName() + " life: "
						+ (free_space.get(i)).getLife());
			else
				System.out.println("index: " + i + " name: " + (free_space.get(i)).getName() + " life: "
						+ (free_space.get(i)).getLife() + " armor "
						+ ((BattleSpaceship) (free_space.get(i))).getArmor());
		System.out.println("");

	}

}
