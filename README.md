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
------------ // Implementing the actions and returning the final attack/defense values in a two-value array  
------------ int[] p1results = getResults(p1actions)  
------------ int[] p2results = getResults(p2actions)  
------------ // Calculates the final HP value  
------------ endTurn(p1results, p2results)  
------------ winner = determineWinner()  
-------- } // end while  
-------- print("The winner is: " + winner)  
---- } else {  
-------- do nothing  
---- } // end if else  
}  

public string[] getActions(player){  
---- // getCombatInput returns the location of actions as a string  

}  

public int[] getResults(string[]){  
---- // Takes the actions chosen and has them use their methods  

}  

public void endTurn(int[] p1result, int[] p2result){  
---- int p1change = p2result[0] - p1result[1]  
---- if(p1change < 1){  
-------- p1change = 1  
---- } // End if
---- player1.setHP(player1.getHP() - p1change)  
---- // Repeat for player 2
---- int p2change = p1result[0] - p2result[1]  
---- if(p2change < 1){  
-------- p2change = 2  
---- } // End if  
---- player2.setHP(player2.getHP() - p2change)
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
-------- if(exclude != string(i)){  
------------ print("Enter " + i + " for " + actions[i])  
-------- } // end if  
---- } // end for  
---- string userInput = get input from user  
---- return userInput  
}  

public int getOffense(){  
---- 
}  

public int getDefense(){  

}  

public string getHP(){  
---- return HP  
}  

### Action Interface

### Attack Class

### Defend Class
