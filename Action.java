// VERSION 1
// Action Interface
// Provides the layout that all other actions must follow.

public interface Action{
	// Data
	String type = "";

	// Methods
	public int getRandomNum(int min, int max);
	public int defend();
	public int attack(int atk, int def);
	public String getType();
	public void setType(String newType);
} // End action
