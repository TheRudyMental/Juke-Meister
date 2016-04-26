package control;

import java.util.ArrayList;

/**
 *
 * @author JamieBurchette
 *
 */
public class Credits implements CreditsIF, CreditSubject{
	/*The things observing the credit controller*/
	private static ArrayList<CreditObserver> o = new ArrayList<CreditObserver>();
	/*Singleton instance of the credit controller*/
	public static CreditsIF instance;

	private int currentCredits;
	private int totalCredits;
	private int songPrice;
	private int buyBonus;
	private int getBonus;
	private int bonusCredits;
	private int creditsEntered;
	private double creditPrice;
	private double currentMoney;

	private Credits(){
		currentCredits = 0;
		totalCredits = 0;
		songPrice = 1;
		buyBonus = 4;
		getBonus = 1;
		bonusCredits = 0;
		creditsEntered = 0;
		creditPrice = 0.25;
		currentMoney = 0;
	}

	public void addCredit(int added){
		creditsEntered += added;
		if(getBonus != 0){
			if(creditsEntered >= buyBonus){
				bonusCredits += creditsEntered / buyBonus;
				creditsEntered -= creditsEntered / buyBonus;
			}
		}
		currentCredits += added;
		totalCredits += added;
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

	public void insertMoney(double amount){
		currentMoney += amount;
		int creditsAdded = (int) (currentMoney / creditPrice);
		currentMoney -= creditsAdded * creditPrice;
		addCredit(creditsAdded);
		notifyObservers();
	}


	@Override
	public void notifyObservers() {
		for(CreditObserver ob: this.o){
			ob.update((currentCredits+bonusCredits));
		}
	}


	public static void register(CreditObserver ob) {
		o.add(ob);
	}

	public static CreditsIF getInstance(){
		if(instance == null){
			instance = new Credits();
		}
		return instance;
	}
}
