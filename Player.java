import java.util.*;
import java.io.*;

// VERSION 1
// Player class
// Holds primary game data, and acesses it

public class Player{
	// Data
	protected int attack = 0;
	protected int defense = 0;
	protected int HP = 0;
	protected int numActions = 0;
	protected Action[] actions = new Action[2];

	// Methods
	public Player(){
		attack = 2;
		defense = 2;
		HP = 15;
		numActions = 2;
		actions[0] = new Attack();
		actions[1] = new Defend();
	} // End constructor

	public int getCombatInput(){
		for(int i = 0; i < actions.length; i++){
			System.out.println("Enter " + i + " for " + actions[i]);
		} // End for
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		int numInput = Integer.parseInt(userInput);
		return numInput;
	} // End getCombatInput

	public int getAttack(){
		return attack;
	} // End getAttack

	public void setAttack(int atk){
		attack = atk;
	} // End setAttack

	public int getDefense(){
		return defense;
	} // End getDefense

	public void setDefense(int def){
		defense = def;
	} // End setDefense

	public int getHP(){
		return HP;
	} // End getHP

	public void setHP(int health){
		HP = health;
	} // End setHP

	public int getNumActions(){
		return numActions;
	} // End getNumActions

	public void setNumActions(int actNum){
		numActions = actNum;
	} // End setNumActions	

	public Action[] getActions(){
		return actions;
	} // End getActions

	public void setActions(Action[] actns){
		actions = actns;
	} // End setActionss
} // End player
