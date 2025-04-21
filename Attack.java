// VERSION 1
// Attack Class
// Follows action interface. Provides a random attack value

public class Attack implements Action{
	// Data
	protected String type = "";

	// Methods
	public Attack(){
		type = "attack";
	} // End constructor

	public int getRandomNum(int min, int max){
		Double randNum = Math.random();
		randNum *= Double.valueOf(max - min);
		randNum += Double.valueOf(min);
		long roundNum = Math.round(randNum);
		int finalNum = (int)roundNum;
		return finalNum;
	} // End getRandomNum

	public int attack(int atk, int def){
		int damage = getRandomNum(1, 6);
		damage += (atk - def);
		if(damage < 1){
			damage = 1;
		} // End if
		return damage;
	} // End attack

	public int defend(){
		return 0;
	} // End defend (empty)

	public String getType(){
		return type;
	} // End getType

	public void setType(String newType){
		if(newType != "attack" & newType != "defense"){
			System.out.println("Invalid type!");
		} else {
			type = newType;
		} // End if/else
	} // End setType
} // End attack
