package control;

/**
 * 
 * @author JamieBurchette
 * An interface to the Credits class to define methods that should be implemented within
 *  @see Credits class to see the documentation for each of the methods below
 */
public interface CreditsIF {
	public void addCredit(int added);
	
	public void setPrice(int newPrice);
	
	public void setBuyBonus(int newBonus);
	
	public void setGetBonus(int newBonus);
	
	public void removeWhenPlay();
	
	public int getCurrentCredits();
	
	public int getTotalCredits();
	
	public void removeCredits();
	
	public void insertMoney(double d);
	
	public void refund();
	
	public double getFunds();
}
