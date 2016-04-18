package Database;

public interface CreditsIF {
	public void addCredit();
	
	public void changePrice(int newPrice);
	
	public void removeWhenPlay();
	
	public int getCurrentCredits();
	
	public int getTotalCredits();
	
	public void removeCredits();
	
	public void refund();
}
