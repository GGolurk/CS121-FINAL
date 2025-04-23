// VERSION 2
// An attack that deals very low damage but ignores defense

public class Pierce implements Action{
	// Data
	String type = "";

	// Methods
	public Pierce(){
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
		int damage = getRandomNum(-3, 3);
		damage += atk;
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
		if(newType.equals("attack") == false & newType.equals("defense") == false){
			System.out.println("Invalid type!");
		} else {
			type = newType;
		} // End if/else
	} // End setType
} // End pierce
