package control;

import java.util.ArrayList;
import control.CreditsIF;
import screen.Screen_2A;
import screen.UIBuilder;

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

	//the number of credits the current user has 
	   // (before a song has played, to give bonus correctly) 
	private int currentCredits;
	//The total amount of credits in the machine
	private int totalCredits;
	//The credit value for each song(always one)
	private int songPrice;
	//The number of credits needed to be bought at once to get bonus credits
	private int buyBonus;
	//the number of credits the user gets when a bonus has been reached
	private int getBonus;
	//the number of bonus credits the user has
	private int bonusCredits;
	private int creditsEntered;
	//The price for a single credit
	private double creditPrice;
	//The money that the current user has entered
	private double currentMoney;
	//The total amount of money that is in the machine 
	private double totalMoney;

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
		totalMoney = 0;
	}

	/**
	* Adds a given amount of credits to the machine
	* @param added the number of credits to be added
	*/
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

	/**
	* Sets the credit price per song
	* @param newPrice the new price of the song
	*/
	public void setPrice(int newPrice){
		creditPrice = newPrice;
	}

	/**
	* Sets the buy bonus for the machine
	*@param the new number of credits to buy to get a bonus
	*/
	public void setBuyBonus(int newBonus){
		buyBonus = newBonus;
	}

	/**
	* Sets the number of extra credits given when a bonus is reached
	*
	*/
	public void setGetBonus(int newBonus){
		getBonus = newBonus;
	}

	/**
	* Removes credit from the user's total when a song is played
	*
	*/
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
		notifyObservers();
		creditsEntered = 0;
	}

	/**
	* Returns the number of credits the user currently has 
	*
	*/
	public int getCurrentCredits(){
		return currentCredits;
	}

	/**
	* Returns the total number of credits in the machine
	*
	*/
	public int getTotalCredits(){
		return totalCredits;
	}

	/**
	* Resets the total number of credits in the machine
	*
	*/
	public void removeCredits(){
		totalCredits = 0;
	}

	/**
	* "Refunds" the credits that the user has yet to spend
	*   and subtracts that from the total in the machine
	*/
	public void refund(){
		totalCredits = totalCredits - currentCredits;
		currentCredits = 0;
	}

	/**
	* Inserts a given amount of money into the machine and 
	*   and calculates the credits to be added based on that and the credit
	*   price
	*@param amount the amount to be added
	*/
	public void insertMoney(double amount){
		MoneyListener ml = UIBuilder.getScreen_2A();
		currentMoney += amount;
		totalMoney += amount;
		int creditsAdded = (int) (currentMoney / creditPrice);
		currentMoney -= creditsAdded * creditPrice;
		addCredit(creditsAdded);
		ml.updateMoney(totalMoney);
		notifyObservers();
	}


	/**
	* Notifies all observers of the credit class of a change in the 
	*   amount of credit
	*
	*/
	@Override
	public void notifyObservers() {
		for(CreditObserver ob: Credits.o){
			ob.update((currentCredits+bonusCredits));
		}
	}


	/**
	* Registers a credit observer to be updated whenever a change occurs
	* @param ob the observer to register
	*
	*/
	public static void register(CreditObserver ob) {
		o.add(ob);
	}

	/**
	* 
	* @return instance, the singleton instance of the screen
	*/
	public static CreditsIF getInstance(){
		if(instance == null){
			instance = new Credits();
		}
		return instance;
	}

	/**
	* Self explanatory getters below  the return the price per song, 
	*  and the total amount of money in the machine respectively
	*
	*/
	public double getPrice(){
		return creditPrice;
	}
	public double getFunds(){
		return totalMoney;
	}

}
