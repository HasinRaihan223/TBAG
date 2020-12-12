import java.util.Scanner;

public class Game {

	Scanner myScanner = new Scanner(System.in);
	Scanner enterScanner = new Scanner(System.in);
	String playerName;
	int playerHP;
	String currentWeapon;
	int choice;

	public static void main(String[]args) {
		Game setUp = new Game();
		setUp.regularSetUp();
		setUp.playerSetUp();
		setUp.CrossRoad();
	}

	public void playerSetUp() {
		playerHP = 100;
		currentWeapon = "Bare Fists";


		//Your stats
		System.out.println("");
		System.out.println("Player Stats:");
		System.out.println("Your HP: " + playerHP);
		System.out.println("Your Weapon: " + currentWeapon);
	}

	public void regularSetUp() {
		System.out.println("Hello player! Please enter your name in the line below:");

		playerName = myScanner.nextLine();

		System.out.println("Welcome " + playerName + " to the Kingdom of Arkadia!");

	}

	public void CrossRoad() {
		System.out.println("--------------------------------------------------------");
		System.out.println("");

		System.out.println("You wake up in a strange crossroad. All you have on you are some plain & ragged clothes.\nAll you can see is an ocean of green. You see 4 prospects that lie ahead of you:");
		System.out.println("\n1: North you see what appears to be a river.\n2: South you see a forest.\n3: East you see what looks like ruins of an old castle.\n4: West you see what looks like the outlines of a small town.");

		System.out.println("\nWhich direction do you want to go?\n<Type the number corresponding to the direction>");

		choice = myScanner.nextInt();

		if (choice==1) {

		}
		else if (choice==2) {

		}

		else if (choice==3) {

		}

		else if (choice==4) {
			TownEntranceEvent();
		}

	}

	public void TownEntranceEvent() {
		System.out.println("--------------------------------------------------------");
		System.out.println("");

		System.out.println("You arrive at the gate of the town and standing in your way is a tall, compactly built guard.");

		System.out.println("\nWhat do you want to do?\n<Type the number corresponding to the action>\n");

		System.out.println("1: Talk to the guard\n2: Leave and go back to the crossroad");

		choice = myScanner.nextInt();

		if (choice==1) {
			System.out.println("\nHello there traveler, I'm sorry but I can't let a stranger into the town.\nMaybe if you come back later with something of value, I just might let you in.\n<Press enter to continue>");
			enterScanner.nextLine();
			TownEntranceEvent();
		}
		else if (choice==2) {
			CrossRoad();
		}

	}

	public void riverEvent() {
		System.out.println("--------------------------------------------------------");
		System.out.println("");

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}


	public void castleEvent() {
		System.out.println("--------------------------------------------------------");
		System.out.println("");

		System.out.println();

	}

	public void forestEvent() {
		System.out.println("--------------------------------------------------------");
		System.out.println("");


	}

	public void gameOver() {

	}
}
