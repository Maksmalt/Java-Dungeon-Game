import java.util.Random;
import java.util.Scanner;

public class DungeonGame {

	public static void main(String[] args) {
		
		// System objects imports
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		// Game variables
		String[] enemies = { "Skeleton", "Zombie", "Goblin", "Assasin", "Orc", "Troll" };
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;
		
		// Player variable
		
		int health = 150;
		int attackDamage = 50;
		int numHealthPotions = 3;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50; //Percentage
		
		boolean running = true;
		
		System.out.println("Welcome to the Dungeon!");
		
		
		GAME:
		while (running) {
			System.out.println("-----------------------------------------------------------------------------------------");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " appeared! #\n");
			
			//     # Skeleton appeared! #    
			
			while(enemyHealth > 0) {
				System.out.println("\tYour HP: " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do? (Enter a number and hit 'Enter')1");
				System.out.println("\t 1. Attack");
				System.out.println("\t 2. Drink Health Potion ");
				System.out.println("\t 3. Run away");
				
				String input = in.nextLine();
				if(input.equals("1")){
					int damageDealt = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
					System.out.println("\t> You received " + damageTaken + " damage.");
					
					if (health < 1) {
						System.out.println("\t> You have been defeated.");
						break;
					}
				}
				else if(input.equals("2")){
					if (numHealthPotions > 0) {
						health += healthPotionHealAmount;
						numHealthPotions--;
						System.out.println("\t>You drink a health potion, healing youself for " + healthPotionHealAmount + ". "
						+ "\n\t>You now have " + health + "HP."
						+ "\n\t> You have " + numHealthPotions + " left.\n");
						
					}
					else {
						System.out.println("\t>You have no Health Potions left in your inventory. Defeat the enemies for a change to get one.");
					}
					
				
				}
				else if(input.equals("3")){
					System.out.println("\t>You run away from the " + enemy + ".");
					continue GAME;
				}
				else{
					System.out.println("\tWrong input, please try again.");
					continue;
				}
			}
			
			if (health < 1) {
				System.out.println("You limp out of the dungeon, weak from battle.");
				break;
			}
			
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println(" # " + enemy +" was defeated. # ");
			System.out.println(" # You have " + health + " HP left." );
			if(rand.nextInt(100) < healthPotionDropChance){
				numHealthPotions ++;
				System.out.println(" # The " + enemy + " dropped a health potion. # ");
				System.out.println(" # You now have " + numHealthPotions + " potion(s) in your inventory. #");
			}
			
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("What would you like to do?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Exit dungeon");
			
			String input = in.nextLine();
			
			while (!input.equals("1") && (!input.equals("2"))){
				System.out.println("Invalid command");
				input = in.nextLine();
			}
			
			if (input.equals("1")){
				System.out.println("You continue exploring dungeon!");
			}
			else if (input.equals("2")){
				System.out.println("You exit the dungeon!");
				break;
			}
		}
		
		System.out.println("########################");
		System.out.println("# Thanks for playing! #");
		System.out.println("########################");
	}

}
