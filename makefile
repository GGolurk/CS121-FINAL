Game.class: Game.java
	javac Game.java

Player.class: Player.java
	javac Player.java

Attack.class: Attack.java
	javac Attack.java

Defend.class: Defend.java
	javac Defend.java

Pierce.class: Pierce.java
	javac Pierce.java

clean:
	rm *.class

all: Game.class Player.class Attack.class Defend.class Pierce.class

run: Game.class Player.class Attack.class Defend.class Pierce.class
	java Game
