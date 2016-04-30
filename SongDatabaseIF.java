package Database;

import java.io.File;

public interface SongDatabaseIF {

	public SongIF getSong(int index);

	public SongIF getSongByTitle(String title);

	public int getSize();

	public void add(SongIF newSong);

	public void remove(int index);

	public void removeByTitle(String title);

	public void addRecord(String text, String text2, int parseInt, File file, File picture);

	public void dropTable();

}
