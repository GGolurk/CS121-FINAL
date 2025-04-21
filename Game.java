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
		
	} // End start
} // End game
