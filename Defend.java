// Needed imports here

// VERSION 1
// Defend Class
// Provides a random damage reduction value

public class Defend implements Action{
	// Data
	protected String type = "";

	// Methods
	public Defend(){
		type = "defense";
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
		return 0;
	} // End attack (empty)

	public int defend(){
		int reduction = getRandomNum(1, 6);
		return reduction;
	} // End defend

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
} // End defend
