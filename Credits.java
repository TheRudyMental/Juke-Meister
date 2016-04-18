package Database;

/**
 * 
 * @author JamieBurchette
 *
 */
public class Credits implements CreditsIF{
	
	private int currentCredits;
	private int totalCredits;
	private int songPrice;
	private int buyBonus;
	private int getBonus;
	private int bonusCredits;
	private int creditsEntered;
	
	public Credits(){
		currentCredits = 0;
		totalCredits = 0;
		songPrice = 1;
		buyBonus = 4;
		getBonus = 1;
		bonusCredits = 0;
		creditsEntered = 0;
	}

	public void addCredit(){
		if(getBonus != 0){			
			if(creditsEntered == buyBonus){
				bonusCredits++;
				creditsEntered = 0;
			}
			else{
				creditsEntered++;
			}
		}
		currentCredits++;
		totalCredits++;
	}
	
	public void setPrice(int newPrice){
		songPrice = newPrice;
	}
	
	public void setBuyBonus(int newBonus){
		buyBonus = newBonus;
	}
	
	public void setGetBonus(int newBonus){
		getBonus = newBonus;
	}
	
	public void removeWhenPlay(){
		if(bonusCredits + currentCredits >= songPrice){
			if(bonusCredits >= songPrice){
				bonusCredits = bonusCredits - songPrice;
			}
			else if(bonusCredits >= 0){
				currentCredits = currentCredits + bonusCredits - songPrice;
				bonusCredits = 0;
			}
			else{
				currentCredits = currentCredits - songPrice;
			}
		}
		else{
			System.out.println("Insufficient Credits");
		}
		creditsEntered = 0;
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
