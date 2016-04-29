package control;

/**
 *
 * @author Grant
 *This interface is to allow the credits class to update the classes that
 *  implement it with the amount of money currently in the machine
 */
public interface MoneyListener {
	/**
	 * Uses the money parameter to update the user totell them how much money
	 *   has been put into the machine.
	 * @param money the amount of money in the machine
	 */
	public void updateMoney(double money);
}
