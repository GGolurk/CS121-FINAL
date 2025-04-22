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
				System.out.println("Player 1 HP: " + player1.getHP() + " Player 2 HP: " + player2.getHP());
				// Getting the ATK/DEF from both players as an array [ATK, DEF]
				// I tweaked these next few lines a lot when designing the algorithm...
				System.out.println("Player 1: Enter Your Actions");
				int[] p1actions = startActions(player1, player2);
				System.out.println("Player 2: Enter Your Actions");
				int[] p2actions = startActions(player1, player2);
				takeDamage(p1actions, p2actions);
				winner = determineWinner();
			} // End while
			System.out.println("The winner is: " + winner);
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

	public void takeDamage(int[] p1atkDef, int[] p2atkDef){
		// In these two-value arrays, value 0 is attack and value 1 is defense. So, this is just reducing HP by atk - def.
		int p1change = p2atkDef[0] - p1atkDef[1];
		// If statement is here to make sure that attacks always deal at least 1 damage, but not if a player doesn't attack.
		if(p1change < 1){
			if(p2atkDef[0] == 0){
				p1change = 0;
			} else {
				p1change = 1;
			} // End if/else
		} // End if
		int p2change = p1atkDef[0] - p2atkDef[1];
		if(p2change < 1){
			if(p1atkDef[0] == 0){
				p2change = 0;
			} else {
				p2change = 1;
			} // End if/else
		} // End if
		// This just prints stuff out to let the players know what's going on.
		System.out.println("Player 1 deals " + p2change + " damage!");
		if(p1atkDef[1] > 0){
			System.out.println("and blocks " + p1atkDef[1] + " damage!");
		} // End if
		System.out.println("Player 2 deals " + p1change + " damage!");
		if(p2atkDef[1] > 0){
			System.out.println("and blocks " + p2atkDef[1] + " damage!");
		} // End if
		player1.setHP(player1.getHP() - p1change);
		player2.setHP(player2.getHP() - p2change);
	} // End takeDamage

	public String determineWinner(){
		int p1health = player1.getHP();
		int p2health = player2.getHP();
		if(p1health <= 0 & p2health > 0){
			return "Player 2!";
		} else {
			if(p2health <= 0 & p1health > 0){
				return "Player 1!";
			} else {
				if(p1health < 1 & p2health < 1){
					return "Nobody! It's a tie!";
				} else {
					return "nobody";
				} // End if/ else 3
			} // End if/else 2
		} // End if/else 1
	} // End determineWinner
} // End game
