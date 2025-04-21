Game.class: Game.java
	javac Game.java

Player.class: Player.java
	javac Player.java

Attack.class: Attack.java
	javac Attack.java

Defend.class: Defend.java
	javac Defend.java

clean:
	rm *.class

all: Game.class Player.class Attack.class Defend.class

run: Game.class Player.class Attack.class Defend.class
	java Game
