package control;

import java.io.File;

public interface SongDatabaseIF {

	public SongIF getSong(int index);

	public SongIF getSongByTitle(String title);

	public int getSize();

	public void add(SongIF newSong);

	public void remove(int index);

	public void removeByTitle(String title);

	public void update(SongIF s);

}
