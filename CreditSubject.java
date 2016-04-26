package control;


/**
 *
 * @author Grant
 * This interface is to be the subject half of the observer pattern,
 *   that will notify observers of any changes if necessary
 */
public interface CreditSubject {
	/**
	 * This method is to go through the observers arraylist and update each
	 *   one
	 */
	public void notifyObservers();

	public static void register(CreditObserver ob) {
	}
}
