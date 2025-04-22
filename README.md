# CS121-FINAL
Final project for CS121.
Made by Nathan Merk.

## Purpose
This short game is designed to show off how much I have learned at this class, how much better  
I've gotten at making algorithms and programs, especially in an Object oriented setting, and  
how I have broadened my understanding of what it means to develop software. Also, the ultimate
purpose of this as a final project is to continue to learn, as I have all semester.

## Overview

## Data Management

## Class Overview

### Action Interface

### Player

### Game

## Use Cases
The primary use case of this program is as a recreational activity between two users.  

## Use of OOP Ideas
This program has been designed with demonstrating the ideas behind OOP programing in mind.  
It features 5 classes and an interface, and demonstrates the main features of OOP programming:
 - Inheritance: Three classes inherit from the Action interface.
 - Encapsulation: Data members are protected but accessible through methods.
 - Polymorphism: The Action interface is has abstract methods designed to change with each implementation.
 - Abstraction: The Action interface is an interface, which is abstract.
 - Aggregation: The Game class holds two instances of the Player class.
 - Composition: The Player class holds an array of Action instances.

## Technology/Implementation
This can easily be written in any OOP language, though I will be using Java for this project as interfaces  
will be useful. There will not be any UI besides the CLI, and there will be no external dependencies.

## Reflection


## Algorithm Planning

### Game Class

Data:
 - player1
 - player2

Methods: 

// Instantiates itself and starts the program  
public static main(String: args[]){  
---- Game game = new Game()  
---- game.start()  
}  

public Game(){  
---- player1 = new Player()  
---- player2 = new Player()  
}  

public void start(){  
---- print("Enter 0 to exit, or 1 to play")  
---- userInput = get the input of the user  
---- if(userInput == 1){  
-------- String winner = "nobody"  
-------- int counter = 1  
-------- while(winner == "nobody"){  
------------ print("TURN " + counter)  
------------ counter++  
------------ // Getting the ATK/DEF from both players as an int array [ATK, DEF]  
------------ int[] p1actions = startActions(player1, player2)  
------------ int[] p2actions = startActions(player2, player1)  
------------ // Takes the atk/def of both players and applies damage  
------------ takeDamage(p1actions, p2actions)  
------------ winner = determineWinner()  
-------- } // end while  
-------- print("The winner is: " + winner)  
---- } else {  
-------- do nothing  
---- } // end if else  
}  

// This needs the opposing player to access their stats, specifically defense
public int[] startActions(player, opponent){  
---- // getCombatInput returns the location of actions as a string  
---- print(player + ": Enter your Actions")  
---- int damage = 0  
---- int defend = 0  
---- int[player.getNumActions()] tempActions = {}  
---- Action[player.getNumActions()] actions = player.getActions()
---- // First for loop gets all actions
---- for(int i = 0; i < player.getNumActions(); i++){  
-------- tempActions[i] = player.getCombatInput()  
---- } // End for  
---- // Second for loop uses all actions
---- for(int j = 0; j < player.getNumActions(); j++){
-------- if(actions[tempActions[j]].getType() == "attack"){  
------------ damage += actions[tempActions[j]].attack(player.getAttack(), opponent.getDefense())  
-------- } else {  
------------ defend += actions[tempActions[j]].defend()  
-------- } // End if/else  
---- } // End for  
---- // Returns data
---- int[] atkDef = {damage, defend}
---- return atkDef[]
}  

public void takeDamage(int[] p1atkDef, int[] p2atkDef){  
---- int p1change = p2atkDef[0] - p1atkDef[1]  
---- if(p1change < 1 and p2atkDef[0] > 0){  
-------- p1change = 1  
---- } // End if  
---- int p2change = p1atkDef[0] - p2atkDef[1]  
---- if(p2change < 1 and p1atkDef[0] > 0){  
-------- p2change = 1  
---- } // End if  
---- player1.setHP(p1.getHP() - p1change)  
---- player2.setHP(p2.getHP() - p2change)  
}  

public string determineWinner(){  
---- int p1health = player1.getHP()  
---- int p2health = player2.getHP()  
---- if(p1health <= 0 and p2health > 0){  
-------- return "Player 2!"  
---- } else if(p2health <= 0 and p1health > 0){  
-------- return "Player 1!"  
---- } else {  
-------- return "Nobody! It's a tie!"  
---- } // end if/else  
}  


### Player Class

Data:
 - int attack
 - int defense
 - int HP
 - Action[] actions
 - int numActions

public int getCombatInput(){  
---- for(int i = 0; i < actions.length(); i++){  
-------- if(exclude != i){  
------------ print("Enter " + i + " for " + actions[i])  
-------- } // end if  
---- } // end for  
---- string userInput = get input from user  
---- return int(userInput)
---- // might validate input if I have time
}  

public int getAttack(){  
---- return attack  
}  

public void setAttack(int atk){
---- attack = atk
}  

public int getDefense(){  
---- return defense  
}  

public void setDefense(int def){  
---- defense = def
}  

public int getHP(){  
---- return HP  
}  

public void setHP(health){  
---- HP = health  
}  

public int getNumActions(){
---- return numActions
}  

public int setNumActions(actNum){  
---- numActions = actNum  
}  

public Action[] getActions(){  
---- return actions
}  

public void setActions(Action[] actns){  
---- actions = actns  
}  

### Action Interface

string type
public int getRandomNum(int min, int max)  
public int attack(int atk, int def)  
public int defend()  
public string getType()
public void setType(string newType)

### Attack Class

type = "attack"

public int getRandomNum(x, y){  
---- // Get random number  
}  

public int attack(int atk, int def){  
---- int damage = getRandomNum(1, 6)  
---- damage += (atk - def)  
---- if(damage < 1){  
-------- damage = 1  
---- } // End if  
---- return damage  
}  

public int defend(){  
---- return 0  
}  

public string getType(){  
---- return type  
}  

public void setType(newType){  
---- if(newType != "attack" and newType != "defense"){
-------- print("Invalid type!")
---- } else {  
-------- type = newType  
---- } // End if/else  
}

### Defend Class

type = "defense"

public int getRandomNum(x, y){  
---- // Get random number  
}  

public int attack(int atk, int def){  
---- return 0
}  

public int defend(){  
---- reduction = getRandomNum(1, 6)  
---- return reduction
}  

public string getType(){  
---- return type  
}  

public void setType(newType){  
---- if(newType != "attack" and newType != "defense"){
-------- print("Invalid type!")
---- } else {  
-------- type = newType  
---- } // End if/else  
}
