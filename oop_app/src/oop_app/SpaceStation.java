package oop_app;

import java.util.ArrayList;

public class SpaceStation implements Stocare {
	private ArrayList<Spaceship> space_station;
	private String color;

	SpaceStation() {
		this.color = "null";
		this.space_station = new ArrayList<Spaceship>();
	}

	SpaceStation(String color) {
		this.color = color;
		this.space_station = new ArrayList<Spaceship>();
	}

	public void add_spaceship(int i) {
		this.space_station.add(space_station.get(i));
		space_station.get(i).setSafe(true);
	}

	public void join_space_station(int i) {
		this.space_station.add(space_station.get(i));
		space_station.get(i).setSafe(true);
	}

	public void join_space_station(Spaceship s) {
		this.space_station.add(s);
		s.setSafe(true);
	}

	public Spaceship leave_space_station(int i) {
		Spaceship aux = space_station.get(i);
		this.space_station.remove(space_station.get(i));
		space_station.get(i).setSafe(false);
		return aux;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Navele spatiale din statia spatiala: " + this.color);
		for (int i = 0; i < space_station.size(); i++)
			if (space_station.get(i).getType() == 0)
				System.out.println("index: " + i + " name: " + (space_station.get(i)).getName() + " life: "
						+ (space_station.get(i)).getLife());
			else
				System.out.println("index: " + i + " name: " + (space_station.get(i)).getName() + " life: "
						+ (space_station.get(i)).getLife() + " armor "
						+ ((BattleSpaceship) (space_station.get(i))).getArmor());
		System.out.println("");

	}
}
