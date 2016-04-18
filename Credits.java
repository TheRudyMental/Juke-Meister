package Database;

public class Credits implements CreditsIF{
	
	public int currentCredits;
	public int totalCredits;
	public int songPrice;
	
	public Credits(){
		currentCredits = 0;
		songPrice = 1;
	}

	public void addCredit(){
		currentCredits++;
		totalCredits++;
	}
	
	public void changePrice(int newPrice){
		songPrice = newPrice;
	}
	
	public void removeWhenPlay(){
		currentCredits = currentCredits - songPrice;
	}
	
	public int getCurrentCredits(){
		return currentCredits;
	}
	
	public int getTotalCredits(){
		return totalCredits;
	}
	
	public void removeCredits(){
		totalCredits = 0;
	}
	
	public void refund(){
		totalCredits = totalCredits - currentCredits;
		currentCredits = 0;
	}
	
}
