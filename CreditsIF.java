package Database;

/**
 * 
 * @author JamieBurchette
 *
 */
public interface CreditsIF {
	public void addCredit();
	
	public void setPrice(int newPrice);
	
	public void setBuyBonus(int newBonus);
	
	public void setGetBonus(int newBonus);
	
	public void removeWhenPlay();
	
	public int getCurrentCredits();
	
	public int getTotalCredits();
	
	public void removeCredits();
	
	public void refund();
}
