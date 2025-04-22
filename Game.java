import java.util.*;
import java.io.*;

// VERSION 1
// Game class
// Organizes player data, runs program.

public class Game{
	// Data
	Player player1;
	Player player2;

	// Methods
	public static void main(String args[]){
		Game game = new Game();
		game.start();
	} // End main

	public Game(){
		player1 = new Player();
		player2 = new Player();
	} // End constructor

	public void start(){
		System.out.println();
		System.out.println("Enter 0 to exit, or 1 to play");
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		if(userInput.equals("1")){
			String winner = "nobody";
			int counter = 1;
			// Playing the game
			while(winner.equals("nobody")){
				System.out.println();
				System.out.println("TURN " + counter);
				counter++;
				// Getting the ATK/DEF from both players as an array [ATK, DEF]
				// I tweaked this area a lot when designing the algorithm...
				System.out.println("Player 1: Enter Your Actions");
				int[] p1actions = startActions(player1, player2);
				System.out.println("Player 2: Enter Your Actions");
				int[] p2actions = startActions(player1, player2);
				winner = "";
			} // End while
		} else {
			System.out.println("ok");
		} // End if/else
	} // End start

	public int[] startActions(Player player, Player opponent){
		int damage = 0;
		int defend = 0;
		int[] tempActions = new int[player.getNumActions()];
		Action[] actions = player.getActions();
		// First for loop gets all actions
		for(int i = 0; i < player.getNumActions(); i++){
			tempActions[i] = player.getCombatInput();
			System.out.print(tempActions[i]);
		} // End for
		// Second for uses all actions
		for(int j = 0; j < player.getNumActions(); j++){
			if(actions[tempActions[j]].getType().equals("attack")){
				damage += actions[tempActions[j]].attack(player.getAttack(), opponent.getDefense());
			} else {
				defend += actions[tempActions[j]].defend();
			} // End if/else
		} // End for
		int[] atkDef = {damage, defend};
		return atkDef;
	} // End startActions
} // End game
