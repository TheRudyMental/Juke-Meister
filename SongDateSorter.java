package Database;

import java.util.Comparator;

public class SongDateSorter implements Comparator<Song>{

	@Override
	public int compare(Song s1, Song s2) {
		if(s1.getDateAdded()>s2.getDateAdded())
			return 1;
		if(s2.getDateAdded()>s1.getDateAdded())
			return -1;
		return 0;
	}

}
