package oop_app;

public abstract class Spaceship {
	private String name;
	private int life;
	private String color;
	private int type;

	private boolean distroyed;
	private boolean safe;
	
	Spaceship() {
		this.setLife(100);
		this.setName("Unnamed");
		this.setDistroyed(false);
		this.setSafe(true);
		this.setColor("blank");
		this.setType(0);
	}

	Spaceship(int life, String name, String color, int type) {
		this.setLife(life);
		this.setName(name);
		this.setDistroyed(true);
		this.setColor(color);
		this.setType(type);
	}

	public abstract void heal();

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDistroyed() {
		return distroyed;
	}

	public void setDistroyed(boolean distroyed) {
		this.distroyed = distroyed;
	}

	public boolean isSafe() {
		return safe;
	}

	public void setSafe(boolean safe) {
		this.safe = safe;
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
