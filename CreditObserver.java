package control;

/**
 *
 * @author Grant
 *	This interface is designed to be the observer half of the
 *   observer pattern, which gets updated by the subject it is
 *   registered with when something is changed in that class
 */
public interface CreditObserver {
	/**
	 * The update method is called when the state of a subject is changed
	 */
	public void update(int credits);
}
