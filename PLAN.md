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
---- player1 = new Player  
---- player2 = new Player  
}  

public start(){  
---- print("Enter 0 to exit, or 1 to play")  
---- userInput = get the input of the user  
---- if(userInput == 1){  
-------- String winner = "nobody"  
-------- int counter = 1  
-------- while(winner == "nobody"){  
------------ print("TURN " + counter)  
------------ counter++  
------------ takeTurn()  
------------ winner = determineWinner()  
-------- } // end while  
-------- print("Winner is " + winner)  
---- } else {  
-------- do nothing  
---- } // end if else  
}  

public takeTurn(){  
---- print("PLAYER 1 ACTIONS")
---- player1.getCombatInput()
}  


### Player Class

### Action Interface

### Attack Class

### Defend Class
