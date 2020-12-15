import java.util.Scanner;

public class Game {

	boolean hasKey;

	Scanner myScanner = new Scanner(System.in);
	Scanner enterScanner = new Scanner(System.in);
	String playerName;
	String currentWeapon;
	int playerHP;
	int choice;
	int weaponDamage = 0;

	boolean hasFist;
	boolean hasKnife;
	boolean hasAxe;

	//Monsters
	int impHP;
	int trollHP;
	int serpentHP;

	boolean defeatedImp;
	boolean defeatedTroll;
	boolean defeatedSerpent;

	public static void main(String[]args) {
		Game setUp = new Game();
		setUp.regularSetUp();
		setUp.playerSetUp();
		setUp.crossRoad();
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
		impHP = 25;
		trollHP = 75;
		serpentHP = 100;
		hasFist = true;
		hasKnife = false;
		hasAxe = false;
		defeatedImp = false;
		defeatedTroll = false;
		defeatedSerpent = false;

		System.out.println("Hello player! Please enter your name in the line below:");

		playerName = myScanner.nextLine();

		System.out.println("Welcome " + playerName + " to the Town of Stratham!");

	}

	public void crossRoad() {
		System.out.println("--------------------------------------------------------");
		System.out.println("");

		System.out.println("You are at a strange crossroad. All you have on you are some plain & ragged clothes.\nAll you can see is an ocean of green. You see 4 prospects that lie ahead of you:");
		System.out.println("\n1: North you see what appears to be a river.\n2: South you see a forest.\n3: East you see what looks like ruins of an old castle.\n4: West you see what looks like the outlines of a small town.");

		System.out.println("\nWhich direction do you want to go?\n<Type the number corresponding to the direction>");

		choice = myScanner.nextInt();

		if (choice==1) {
			riverEvent();
		}
		else if (choice==2) {
			forestEvent();
		}

		else if (choice==3) {
			castleEvent();
		}

		else if (choice==4) {
			TownEntranceEvent();
		}

	}

	public void TownEntranceEvent() {
		System.out.println("--------------------------------------------------------");
		System.out.println("");

		if (hasKnife==true) {
			System.out.println("You are now allowed to enter the town of Stratham!");

			System.out.println("\nWhat do you want to do?\n<Type the number corresponding to the action>\n");
			System.out.println("1: Enter the Town of Stratham\n2: Leave and go back to the crossroad.");

			choice = myScanner.nextInt();

			if (choice==1) {
				enterTown();
			}

			if (choice==2) {
				crossRoad();
			}
		}

		else {
			System.out.println("You arrive at the gate of the town called Stratham and standing in your way is a tall, compactly built guard.");

			System.out.println("\nWhat do you want to do?\n<Type the number corresponding to the action>\n");

			System.out.println("1: Talk to the guard\n2: Leave and go back to the crossroad");

			choice = myScanner.nextInt();

			if (choice==1) {
				if (defeatedImp==true && hasFist==true && hasKnife == false && hasAxe == false) {
					System.out.println("Hello there traveler.\nWOW! You managed to kill that imp that has been harassing our town.\nYour welcome to enter our town anytime.");
					System.out.println("In fact, let me give you a small prize!");
					System.out.println("");

					currentWeapon = "Small Knife";
					System.out.println("You have obtained a " + currentWeapon + " from the guard!");
					hasFist = false;
					hasAxe = false;
					hasKnife = true;

					System.out.println("\nWith you new weapon you venture confidently back to the crossroad");
					System.out.println("<Press enter to continue>");
					enterScanner.nextLine();
					crossRoad();
				}

				if (defeatedImp==true && hasFist==false) {
					System.out.println("\nHello there traveler.\nWOW! You managed to kill that imp that has been harassing our town.\nYour welcome to enter our town anytime.\n");

					System.out.println("You are now allowed to enter the town of Stratham!");

					System.out.println("\nWhat do you want to do?\n<Type the number corresponding to the action>\n");
					System.out.println("1: Enter the Town of Stratham\n2: Leave and go back to the crossroad.");

					choice = myScanner.nextInt();

					if (choice==1) {
						enterTown();
					}

					if (choice==2) {
						crossRoad();
					}
				}

				else {
					System.out.println("\nHello there traveler, I'm sorry but I can't let a stranger into the town.\nMaybe if you come back later with something of value, I just might let you in.");
					System.out.println("<Press enter to continue>");
					enterScanner.nextLine();
					TownEntranceEvent();
				}
			}

			else if (choice==2) {
				crossRoad();
			}
		}
	}

	//Tavern Method in town
	public void enterTown() {
		System.out.println("--------------------------------------------------------");
		System.out.println("");

		System.out.println("You are now in the Town of Stratham.\n\nSince you have killed the feral imp, that was harassing the town, the local Tavern decided to give you unlimited food and drinks!");
		System.out.println("Do you wish to enter the Tavern?");
		System.out.println("<Type the number corresponding to the action>");

		System.out.println("\n1: Yes\n2: No");

		choice = myScanner.nextInt();

		if (choice==1) {
			inTavern();
		}

		if (choice==2) {
			TownEntranceEvent();
		}

		else {
			enterTown();
		}

	}

	public void inTavern() {
		System.out.println("--------------------------------------------------------");
		System.out.println("");

		System.out.println("You have entered the Tavern. The food here is rumored to heal people.\nWhat do you wish to do?");
		System.out.println("<Type the number corresponding to the action>");

		System.out.println("\n1: Order some food\n2: Order a drink\n3: Exit Tavern");

		choice = myScanner.nextInt();

		if (choice==1) {
			System.out.println("\nYou order some delicious cooked meat.");
			if (playerHP >= 100) {
				checkHealth();
				System.out.println("You are already at full health. You cannot heal any further, so you decide to leave the Tavern.");
				System.out.println("<Press enter to exit Tavern>");
				enterScanner.nextLine();
				enterTown();
			}
			if (playerHP < 100) {
				System.out.println("The food was so good that it healed you!\nYou have gained 5 HP back!");
				playerHP += 5;
				checkHealth();
				System.out.println("You are now at " + playerHP);
			}
		}

		if (choice==2) {
			System.out.println("\nYou order some strong ale.");
			if (playerHP >= 100) {
				checkHealth();
				System.out.println("You are already at full health. You cannot heal any further, so you decide to leave the Tavern.");
				System.out.println("<Press enter to exit Tavern>");
				enterScanner.nextLine();
				enterTown();
			}
			if (playerHP < 100) {
				System.out.println("The ale was so tasty that it healed you!\nYou have gained 2 HP back!");
				playerHP += 2;
				checkHealth();
				System.out.println("You are now at " + playerHP);
			}
		}

		if (choice==3) {
			enterTown();
		}

		else {
			inTavern();
		}
	}

	public void checkHealth() {
		if (playerHP >= 100) {
			playerHP = 100;
		}
	}

	//IMPLEMENT!!!!!!!!!!!!!!! FINISH THIS LAST METHOD HASIN!!!!!

	public void riverEvent() {
		System.out.println("--------------------------------------------------------");
		System.out.println("");

		System.out.println("You venture closer and closer to the river.");
		System.out.println("You see what looks like a slumbering beast.\nUpon closer inspection, you realize that it is a giant river serpent.");

		if (defeatedImp==true & defeatedTroll==true) {
			System.out.println("As you near the giant serpent, you accidentally step on a twig, which awakens the river serpent.\nIt darts rapidly at you and starts coiling itself around you, tightening its grip with every passing second. What do you do player?");
			System.out.println("<Type the number corresponding to the action>");

			System.out.println("\n1: Fight back\n2: Try to wiggle free");

			choice = myScanner.nextInt();

			if (choice==1) {
				serpentFight();
			}

			if (choice==2) {
				//Random thing!
			}

			else {
				riverEvent();
			}

		}

		else {
			System.out.println("You try to tread closer but something is stopping you.\nYou physically can’t go any closer to the slumbering serpent.\nMaybe get stronger by fighting other monsters and come back.\nLet's go back to the crossroad for now.");
			System.out.println("<Press enter to continue>");
			enterScanner.nextLine();
			crossRoad();
		}

	}

	public void castleEvent() {

		if (defeatedTroll == true) {
			System.out.println("You go back to the ruins for further exploration. Nothing of interest was found, so you go back to the crossroad.");
			System.out.println("<Press enter to continue>");
			enterScanner.nextLine();
			crossRoad();
		}

		else {
			System.out.println("--------------------------------------------------------");
			System.out.println("");

			System.out.println("As you near the castle ruins you look around and see that nature has reclaimed the place.\nIt is overgrown with plants and vines.\nA large troll jumps in front of you, and screams in an unintelligible language.\n");
			System.out.println("You have encountered a large troll. What do you do player?\n<Type the number corresponding to the action>\n");
			System.out.println("1: Run away\n2: Fight back");

			choice = myScanner.nextInt();

			if (choice==1) {
				System.out.println("You wish to live to see the light of day and so you try to run away.");
				System.out.println("However the troll is faster and with one swing of his axe he chops your head off clean.");
				playerHP = 0;
				gameOver();
			}

			if (choice==2) {
				trollFight();
			}

			else {
				castleEvent();
			}
		}
	}

	public void forestEvent() {

		if (defeatedImp == true) {
			System.out.println("The forset grows dense. There seems to be nothing more here but vegetation. Well better go back to the crossroad.");
			System.out.println("<Press enter to continue>");
			enterScanner.nextLine();
			crossRoad();
		}

		System.out.println("--------------------------------------------------------");
		System.out.println("");

		System.out.println("You venture deep into the forest.\nThe vegetation start growing wilder and the wind starts howling more ferociously.");
		System.out.println("You stumble across a bush and you realize that something is moving behind it.");
		System.out.println("Suddenly a feral Imp jumps up and tackles you!\n");

		System.out.println("You have encountered a Feral Imp. What do you do player?\n<Type the number corresponding to the action>\n");

		System.out.println("1: Run away\n2: Fight back");

		choice = myScanner.nextInt();

		if (choice==1) {
			System.out.println("You dont want to fight a feral imp today so you run as fast as your legs can take you all the way back to the corssroad.");
			System.out.println("<Press enter to continue>");
			enterScanner.nextLine();
			crossRoad();
		}

		if (choice==2) {
			impFight();
		}

		else {
			forestEvent();
		}

	}

	//Imp fight event

	public void impFight() {
		System.out.println("--------------------------------------------------------");
		System.out.println("");

		System.out.println("Your HP: "+ playerHP);
		System.out.println("Feral Imp HP: " + impHP);

		System.out.println("\n1: Attack");
		System.out.println("2: Run");

		choice = myScanner.nextInt();

		if(choice==1){
			impAttack();
		}
		else if(choice==2){
			crossRoad();
		}
		else{
			impFight();
		}
	}

	public void impAttack() {
		Weapon();

		System.out.println("You attacked the monster and gave it " + weaponDamage + " damage!");

		impHP -= weaponDamage;

		System.out.println("Feral Imp HP: " + impHP);

		if (impHP <= 0) {
			winImp();
		}

		if (impHP > 0) {
			int monsterDamage  = 0;
			monsterDamage = new java.util.Random().nextInt(6);

			System.out.println("Monster attacked you and it gave you " + monsterDamage + " damage!");

			playerHP -= monsterDamage;

			if (playerHP<=0) {
				playerHP = 0;
				gameOver();
			}

			System.out.println("Player HP: " + playerHP);

			if(playerHP>0){
				impFight();
			}
		}
	}


	//Troll fight event

	public void trollFight() {
		System.out.println("--------------------------------------------------------");
		System.out.println("");

		System.out.println("Your HP: "+ playerHP);
		System.out.println("Troll HP: " + trollHP);

		System.out.println("\n1: Attack");
		System.out.println("2: Run");

		choice = myScanner.nextInt();

		if(choice==1){
			trollAttack();
		}
		else if(choice==2){
			crossRoad();
		}
		else{
			trollFight();
		}
	}

	public void trollAttack() {
		Weapon();

		System.out.println("You attacked the monster and gave it " + weaponDamage + " damage!");

		trollHP -= weaponDamage;

		System.out.println("Troll HP: " + trollHP);

		if (trollHP <= 0) {
			winTroll();
		}

		if (trollHP > 0) {
			int monsterDamage = 0;
			monsterDamage = new java.util.Random().nextInt(16);

			System.out.println("Monster attacked you and it gave you " + monsterDamage + " damage!");

			playerHP -= monsterDamage;

			if (playerHP<=0) {
				gameOver();
			}

			System.out.println("Player HP: " + playerHP);

			if(playerHP>0){
				trollFight();
			}
		}
	}

	//Serpent fight event

	public void serpentFight() {
		System.out.println("--------------------------------------------------------");
		System.out.println("");

		System.out.println("Your HP: "+ playerHP);
		System.out.println("Giant Serpent HP: " + serpentHP);

		System.out.println("\n1: Attack with all your might!");

		choice = myScanner.nextInt();

		if(choice==1){
			serpentAttack();
		}
		else{
			serpentFight();
		}
	}

	public void serpentAttack() {
		Weapon();

		System.out.println("You attacked the monster and gave it " + weaponDamage + " damage!");

		serpentHP -= weaponDamage;

		System.out.println("Giant Serpent HP: " + serpentHP);

		if (serpentHP <= 0) {
			winSerpent();
		}

		if (serpentHP > 0) {
			int monsterDamage = 0;
			monsterDamage = new java.util.Random().nextInt(21);

			System.out.println("Monster attacked you and it gave you " + monsterDamage + " damage!");

			playerHP -= monsterDamage;

			if (playerHP<=0) {
				gameOver();
			}

			System.out.println("Player HP: " + playerHP);

			if(playerHP>0){
				serpentFight();
			}
		}
	}

	//Weapon method
	public void Weapon() {
		if (currentWeapon.equals("Bare Fists")) {
			weaponDamage = new java.util.Random().nextInt(6);
		}

		if (currentWeapon.equals("Small Knife")) {
			weaponDamage = new java.util.Random().nextInt(11);
		}

		if (currentWeapon.equals("Battle Axe")) {
			weaponDamage = new java.util.Random().nextInt(21);
		}
	}

	//Lose conditions

	public void gameOver() {
		System.out.println("\nOh no player, your health is at 0! You have died! You will respawn at the crossroad.");
		System.out.println("<Press enter to continue>");
		enterScanner.nextLine();
		respawn();
	}

	public void respawn() {
		playerHP = 100;
		crossRoad();
	}

	//Win conditions

	public void winImp() {
		defeatedImp = true;
		System.out.println("\nYou killed the feral imp! That was an exhilerating battle!");
		System.out.println("After lingering for a while longer you decide to go back to the crossroad.");
		System.out.println("<Press enter to continue>");
		enterScanner.nextLine();
		crossRoad();
	}

	public void winTroll() {
		defeatedTroll = true;
		System.out.println("\nYou killed the troll!");
		System.out.println("\nThe troll dropped his battle axe!");
		currentWeapon = "Battle Axe";
		hasFist = false;
		hasKnife = false;
		hasAxe = true;
		System.out.println("You have obtained a " + currentWeapon);
		System.out.println("<Press enter to continue>");
		enterScanner.nextLine();

		System.out.println("You look around the ruins a while more and you see nothing of interest.");
		System.out.println("Finally you decide to go back to the crossroad.");
		System.out.println("<Press enter to continue>");
		enterScanner.nextLine();
		crossRoad();
	}

	public void winSerpent() {
		defeatedSerpent = true;
		System.out.println("\nYou killed the giant river serpent!");
		System.out.println("The rummage through the body of slain serpent and a shiny golden key catches your eye.\nWhat might this key be used for?");
		hasKey = true;
		System.out.println("You have obtained a Key");
		System.out.println("<Press enter to continue>");
		enterScanner.nextLine();
		winEvent();
	}

	//Ending

	public void winEvent() {
		if (defeatedImp & defeatedTroll & defeatedSerpent) {
			System.out.println("You decide to return to the Town of Stratham after your legendary battle with the Giant Serpent.\nThe residents welcome you with open arms. They celebrate your heroic victory!\nWell done player!\nYou have beaten the game...for now.\n");
			System.out.println("To be continued!\n");
			System.out.println("<----------------------------------------------------------------->");
			System.out.println("                   THE END!!!! THANK YOU FOR PLAYING!              ");
			System.out.println("<----------------------------------------------------------------->");
			restart();
		}
	}

	public void restart() {
		System.out.println("");
		System.out.println("");
		System.out.println("");

		System.out.println("It appears you have won player!");
		System.out.println("Press enter if you wish to restart the game");
		enterScanner.nextLine();
		regularSetUp();
		playerSetUp();
		crossRoad();
	}

}
