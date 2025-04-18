# CS121-FINAL
Final project for CS121.


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
------------ // Getting the actions from both players as an array  
------------ string[] p1actions = getActions(player1)  
------------ string[] p2actions = getActions(player2)  
------------ // I decided to separate the actions into two parts, the attack and the defense/implementation.  
------------ // I thought this would be the most streamlined way to do it without forcing everything into one massive procedural function,  
------------ // dividing the data into one part which messes with the player's data, and one part which messes with the opponent's data.  
------------ int p1attack = getAttack(player1, p1actions)  
------------ int p2attack = getAttack(player2, p2actions) 
------------ // takeDamage deals with taking damage and reducing damage taken
------------ takeDamage(player2, p1attack)  
------------ takeDamage(player1, p2attack)  
------------ winner = determineWinner()  
-------- } // end while  
-------- print("The winner is: " + winner)  
---- } else {  
-------- do nothing  
---- } // end if else  
}  

public int[] getActions(player){  
---- // getCombatInput returns the location of actions as a string  
---- print(player + ": Enter your Actions")
---- string action1 = player.getCombatInput()
---- string action2 = player.getCombatInput(action1)
}  

public int getAttack(player, int[] actions){  
---- // Takes the actions chosen and has them use their methods  
---- Action[] useActions = player.getActions()  
---- int[] tempDamage = {0, 0}  
---- if(useActions[actions[0]].getType() == "attack"){  
-------- if(tempDamage[0] == 0){  
------------ tempDamage[0] = useActions[actions[0]].attack()  
-------- } // End if  
---- } // End if   
---- if(useActions[actions[1]].getType() == "attack"){  
-------- if(tempDamage[0] == 0){  
------------ tempDamage[0] = useActions[actions[1]].attack()  
-------- } else {  
------------ tempDamage[1] = useActions[actions[1]].attack()  
-------- } // End else  
---- } // End if   
}  

public void takeDamage(player, int damage){  
---- //  
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
 - array actions

public string getCombatInput(exclude){  
---- for(int i = 0; i < actions.length(); i++){  
-------- if(exclude != i){  
------------ print("Enter " + i + " for " + actions[i])  
-------- } // end if  
---- } // end for  
---- string userInput = get input from user  
---- return int(userInput)
---- // might validate input if I have time
}  

public int getAttackValue(){  

}  

public int getDefenseValue(){  

}  

public string getHP(){  
---- return HP  
}  

### Action Interface

### Attack Class

### Defend Class
