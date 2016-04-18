package Database;

import java.io.File;

public interface SongIF {
	
	public String getTitle();
	
	public String getArtist();

	public int getYear();
	
	public File getSongFile();
	
	public File getPicture();
	
	public int getId();
	
	public int getWeekCount();
	
	public int getMonthCount();
	
	public String getPlayingTime();
	
	public void setTitle(String title);
	
	public void setArtist(String artist);

	public void setYear(int year);
	
	public void setSongFile(File songFile);
	
	public void setPicture(File picture);
	
	public void setId(int id);
	
	public void setWeekCount(int weekCounter);
	
	public void setMonthCount(int monthCounter);
	
	public void setPlayingTime(String playingTime);
	
	public boolean equals(String title);
	
}
