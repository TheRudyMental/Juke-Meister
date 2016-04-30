package control;

/**
 * 
 * @author JamieBurchette
 *
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
