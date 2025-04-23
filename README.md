# CS121-FINAL
Final project for CS121.
Made by Nathan Merk.

## Purpose
This short game is designed to show off how much I have learned at this class, how much better  
I've gotten at making algorithms and programs, especially in an Object oriented setting, and  
how I have broadened my understanding of what it means to develop software. Also, the ultimate  
purpose of this as a final project is to continue to learn, as I have all semester.

## Overview
This project is a mostly faithful recreation of the combat of the Dino Fight, the game I have  
been creating in my CS215 class this semester. The combat revolves around the actions that players  
can take in a turn, of which I have limited in scope to two types: offensive types, and defensive  
types. The idea is that players will enter their actions one after the other, and they will both  
happen at the same time, reducing the HP of both players until it reaches 0. 

## Data Management
When initially thinking about the project, I recognized that to get damage from one player to the  
other I would need to get a player's offensive actions, increase/decrease the individual attack  
amounts by the player's attack stat and opponent's defense stat, combine all of the modified values  
into one final damage value, decrease that damage value by the final defensive value of the opponent,  
generated from all of their defensive actions, and finally reduce the opponent's HP by the remaining  
value, which has a minimum of one if an attack has been made.  

This was correct, but in my continued design I wasn't entirely sure how to manage the data between  
the two players, ultimately having one method which gets the player actions triggered once for each  
player, with it taking the player objects as input, and a second method which triggers only once and  
takes the final offense/defense values in int[] format from the previous methods as input. This one  
takes the combined attack value minus the opponent's final defense value, and makes the players take  
damage.  

## Class Overview

### Action Interface
The Action interface is here to define the rules for actions. Every action must have a type, must  
have an attack method and a defend method (usually one of these is empty), and must generate a random
integer.  

Though this is not explicitly defined in the action interface, the two types of actions used in this  
program are "attack" and "defense" actions, which are used to either increase damage dealt or reduce  
damage taken.  

### Player
The primary purpose of the player class is to store all of the actions and stats used in combat.  
These stats are:
 - attack, which adds itself to any damage dealt.
 - defense, which decreases itself from any damage taken.
 - HP, which is what takes damage.
 - numActions, which is the number of actions a player can take in a turn.
 - actions, which is an array that stores the actions a player can take.

The player class can also contain methods that help access and modify these stats, and they are all  
designed and managed throughout the program so in such a way that they can be modified.  
Specifically, these are the upgrade and getCombatInput methods.

### Game
The game class is the primary class of this program, and it organizes all the data and really makes  
the game run. Its purpose is to organize the whole program, and make it run on a macro level. This  
is the class that contains the two players, and has the main responsibility of organizing all of  
their data, making sure that both players submit actions, get the results of those actions, get a  
final attack/defense value, and take damage.  

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
I learned a lot from this project, especially in class the day before it was due. To be perfectly honest,  
most of what I wrote here was on the day before this project was due. That isn't to say I didn't do any of  
this before, I thought about this a lot, I just didn't document it. That's probably my biggest takeaway from  
this project, DOCUMENTATION IS IMPORTANT. DOCUMENT YOUR STUFF. Part of that is thinking about what you want  
done before you even begin designing the UML, something I kinda did but it wasn't ideal. There's a lot about  
this project that wasn't ideal, and if I had more time I would kill all the files and do some serious reworking  
on the algorithm, starting by catching up on the thinking I should have done more of before creating it.  
But that's kinda the point of this. I'm going to mess up, goof around a little, and submit code that is  
functional but not really ideal, which is the second thing I learned about this project, implementation is so,  
so much easier than design. I know we've been talking about how that's the case the whole semester but oh my  
it was so much easier. Maybe it's cause my algorithm is way too specific, but even so it was refreshingly simple.  

At the end of this, I can see this is certainly the work of someone who hasn't made their own documentation before,  
but this is the best I've done so far, and I'm proud of it. Compared to the spaghetti pool that happened when I  
tried to make a (fully procedural, I didn't know how to use OOP) game in high school, this is a massive success.

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
-------- while(keepGoing == true!){  
------------ String winner = "nobody"  
------------ int counter = 1  
------------ while(winner == "nobody"){  
---------------- print("TURN " + counter)  
---------------- counter++  
---------------- // Getting the ATK/DEF from both players as an int array [ATK, DEF]  
---------------- int[] p1actions = startActions(player1, player2)  
---------------- int[] p2actions = startActions(player2, player1)  
---------------- // Takes the atk/def of both players and applies damage  
---------------- takeDamage(p1actions, p2actions)  
---------------- winner = determineWinner()  
------------ } // end while  
------------ keepGoing = postFight()
-------- } // End while  
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

public bool postFight(){  
---- ask user if they want to keep playing  
---- if no, return FALSE  
---- if yes{  
-------- player1.upgrade()  
-------- player1.upgrade()  
-------- player2.upgrade()   
-------- player2.upgrade()  
-------- return TRUE   
---- }  
}

### Player Class

Data:
 - int attack
 - int defense
 // HP is an array to store max HP and current HP  
 - int[] HP
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

public void upggrade(){  
---- print("Enter 0 to upgrade attack")  
---- print("Enter 1 to upgrade defense")  
---- print("Enter 2 to upgrade HP")  
---- print("Enter 3 to upgrade number of actions")  
---- input = get player input  
---- if input == 0{  
-------- setAttack(getAttack()++)  
---- }  
---- if input == 1{  
-------- setDefense(getDefense()++)  
---- }  
---- if input == 2{  
-------- setHP(getHP() + 2)  
---- }  
---- if input == 3{  
-------- setNumActions(getNumActions()++)  
---- }  
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

### Pierce Class
// An attack that deals low damage but ignores defense

type = "attack"

public int getRandomNum(x, y){  
---- // Get random number  
}  

public int attack(int atk, int def){  
---- int damage = getRandomNum(-3, 3)  
---- damage += atk  
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
