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
------------ get actions from players, get defense/offense from actions, resolve actions  
------------ just go back to takeTurn method, maybe takeTurn(player)?  
------------ winner = determineWinner()  
-------- } // end while  
-------- print("Winner is " + winner)  
---- } else {  
-------- do nothing  
---- } // end if else  
}  

// CURRENTLY IN PROGRESS  
public int takeTurn(player){  
// getCombatInput returns the location of actions as a string  
---- print(player + " ACTIONS")  
---- string first = player1.getCombatInput()  
---- string second = player1.getCombatInput(first)     
---- int attack = player1.determineAttack(first, second)  
---- int defense = player2.determineDefense(first, second)  
---- player  
}  


### Player Class

Data:
 - int attack
 - int defense
 - int HP
 - array actions

public string getCombatInput(exclude){  
---- for(int i = 0; i < actions.length(); i++){  
-------- if(exclude != string(i)){  
------------ print("Enter " + i + " for " + actions[i])  
-------- } // end if  
---- } // end for  
---- string userInput = get input from user  
---- return userInput  
}  

### Action Interface

### Attack Class

### Defend Class
