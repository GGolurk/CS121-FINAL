import java.util.*;
import java.io.*;

// VERSION 1
// Player class
// Holds primary game data, and acesses it

public class Player{
	// Data
	protected int attack = 0;
	protected int defense = 0;
	protected int[] HP = new int[2];
	protected int numActions = 0;
	protected Action[] actions = new Action[3];

	// Methods
	public Player(){
		attack = 2;
		defense = 2;
		HP[0] = 15;
		HP[1] = 15;
		numActions = 2;
		actions[0] = new Attack();
		actions[1] = new Defend();
		actions[2] = new Pierce();
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

	public void upgrade(){
		System.out.println("Enter 0 to upgrade attack");
		System.out.println("Enter 1 to upgrade defense");
		System.out.println("Enter 2 to upgrade HP");
		System.out.println("Enter 3 to upgrade number of actions");
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		if(userInput.equals("0")){
			setAttack(getAttack() + 1);
			System.out.println("New attack: " + getAttack());
		} // End if
		if(userInput.equals("1")){
			setDefense(getDefense() + 1);
			System.out.println("New defense: " + getDefense());
		} // End if
		if(userInput.equals("2")){
			setMaxHP(getMaxHP() + 3);
			System.out.println("New HP: " + getMaxHP());
		} // End if
		if(userInput.equals("3")){
			setNumActions(getNumActions() + 1);
			System.out.println("New number of actions: " + getNumActions());
		} // End if
	} // End upgrade
	
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
		return HP[0];
	} // End getHP

	public int getMaxHP(){
		return HP[1];
	} // End getMaxHP()

	public void setHP(int health){
		HP[0] = health;
	} // End setHP

	public void setMaxHP(int health){
		HP[1] = health;
	} // End setMaxHP();

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
