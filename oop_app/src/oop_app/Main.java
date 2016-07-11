package oop_app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FreeSpace free_space = new FreeSpace();
		SpaceStation space_station1 = new SpaceStation("green");
		SpaceStation space_station2 = new SpaceStation("red");

		space_station1.join_space_station(new BattleSpaceship(100, 120, "nava_verde_de_atac_1", "verde", 1));
		space_station1.join_space_station(new BattleSpaceship(100, 90, "nava_verde_de_atac_2", "verde", 1));
		space_station2.join_space_station(new BattleSpaceship(100, 130, "nava_rosie_de_atac_1", "rosie", 1));
		space_station2.join_space_station(new BattleSpaceship(100, 100, "nava_rosie_de_atac_2", "rosie", 1));

		space_station1.join_space_station(new SimpleSpaceship(100, "nava_simpla_verde_1", "verde", 0));
		space_station1.join_space_station(new SimpleSpaceship(100, "nava_simpla_verde_2", "verde", 0));
		space_station2.join_space_station(new SimpleSpaceship(100, "nava_simpla_rosie_1", "rosie", 0));

		int opt = 10;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		while (opt != 0) {
			System.out.println("0-exit");
			System.out.println("1-show space station green (index 1)");
			System.out.println("2-show space station red (index 2)");
			System.out.println("3-show free_space");
			System.out.println("4-meniu actiuni");
			System.out.println("");
			try {
				opt = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("can read only integers!!!");
				input.nextInt();
			}
			switch (opt) {
			case 1:
				space_station1.print();
				break;
			case 2:
				space_station2.print();
				break;
			case 3:
				free_space.print();
				break;
			case 4: {
				int opt2 = 0;
				System.out.println("0-exit");
				System.out.println("1-move spaceship to freespace");
				System.out.println("2-move spaceship to space station");
				System.out.println("3-attack");
				System.out.println("");
				try {
					opt2 = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("can read only integers!!!");
					input.nextInt();
				}
				switch (opt2) {
				case 1: {
					System.out.println("index of spaceship to move into free space");
					int sel_spaceship = 0;
					try {
						sel_spaceship = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("can read only integers!!!");
						input.nextInt();
					}
					System.out.println("in which spacestation is the spaceship located? : ");
					int sel_spacestation = 0;
					try {
						sel_spacestation = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("can read only integers!!!");
						input.nextInt();
					}
					Spaceship aux;
					if (sel_spacestation == 1)
						aux = space_station1.leave_space_station(sel_spaceship);
					else
						aux = space_station2.leave_space_station(sel_spaceship);
					free_space.join_free_space(aux);
				}
					break;
				case 2: {
					System.out.println("index of spaceship to move into spacestation");
					int sel_spaceship = 0;
					try {
						sel_spaceship = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("can read only integers!!!");
						input.nextInt();
					}
					System.out.println("spacestation number to move in ");
					Spaceship aux;
					int sel_spacestation = 0;
					try {
						sel_spacestation = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("can read only integers!!!");
						input.nextInt();
					}
					aux = free_space.leave_free_space(sel_spaceship);
					if (sel_spacestation == 1)
						space_station1.join_space_station(aux);
					else
						space_station2.join_space_station(aux);
				}
					break;
				case 3: {
					Spaceship aux = new SimpleSpaceship();
					System.out.println("index of spaceship from freespace that attacks");
					int sel_spaceship1 = 0;
					try {
						sel_spaceship1 = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("can read only integers!!!");
						input.nextInt();
					}
					System.out.println("index of spaceship from freespace to be attacked");
					int sel_spaceship2 = 0;
					try {
						sel_spaceship2 = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("can read only integers!!!");
						input.nextInt();
					}
					try {
						aux = free_space.battle(sel_spaceship1, sel_spaceship2);
					} catch (CustomException e) {
						// TODO Auto-generated catch block
						System.out.println("Exception occured: " + e);
					} finally {
						free_space.leave_free_space(sel_spaceship2);
						free_space.join_free_space(aux);
					}
				}
					break;
				case 0:
					break;
				}
			}
				break;
			case 0:
				break;
			}
		}

	}

}
