package control;



/**
 *
 * @author Grant
 * This interface is to allow the class that implements this (Screen 2D1)
 *  to update its listeners to what the new venue and message names are
 */
public interface VenueAndMessageSubject {
	/*Call the update method of any and all listeners to the class that
	 *  implements it*/
	public void notifyListeners(String s, String m);
}
