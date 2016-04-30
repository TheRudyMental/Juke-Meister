package Database;

import java.util.Comparator;

/**
* This class is to compare two songs' week counter values,
*   used to determine the popularity of the songs
*
*/
public class SongCountSorter implements Comparator<Song> {

	@Override
	public int compare(Song s1, Song s2) {
		if(s1.getWeekCount()>s2.getWeekCount())
			return 1;
		if(s2.getWeekCount()>s1.getWeekCount())
			return -1;
		return 0;
	}


}
