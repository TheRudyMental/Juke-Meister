package control;

import screen.Screen_2D1;

/**
 *
 * @author Grant
 * This interface is to allow classes that implement this interface to be
 *  updated when the venue name and/or message change in Screen_2D1
 */
public interface VenueAndMessageListener {
	public void updateVenueName(String newName);

	public void updateMessage(String newMessage);
}
