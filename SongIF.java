package Database;

import java.io.File;

public interface SongIF {
	/**
	 *
	 * @return song title
	 */
	public String getTitle();
	/**
	 *
	 * @return artist
	 */
	public String getArtist();
	/**
	 *
	 * @return year
	 */
	public int getYear();
	/**
	 *
	 * @return song file
	 */
	public File getSongFile();
	/**
	 *
	 * @return picture file
	 */
	public File getPicture();
	/**
	 *
	 * @return id in DB
	 */
	public int getId();
	/**
	 *
	 * @return # of times played per week
	 */
	public int getWeekCount();
	/**
	 *
	 * @return # of months
	 */
	public int getMonthCount();
	/**
	 *
	 * @return miliseconds since 1/1/1970
	 */
	public long getDateAdded();
	/**
	 *
	 * @param title
	 */
	public void setTitle(String title);
	/**
	 *
	 * @param artist
	 */
	public void setArtist(String artist);
	/**
	 *
	 * @param year
	 */
	public void setYear(int year);
	/**
	 *
	 * @param songFile
	 */
	public void setSongFile(File songFile);
	/**
	 *
	 * @param picture
	 */
	public void setPicture(File picture);
	/**
	 *
	 * @param id
	 */
	public void setId(int id);
	/**
	 *
	 * @param weekCounter
	 */	
	public void setWeekCount(int weekCounter);
	/**
	 * @param monthCounter
	 */
	public void setMonthCount(int monthCounter);
	/**
	 * adds to the count
	 */
	public void addCount();
	/**
	 * resets the weekcounter
	 */
	public void resetWeek();
	/**
	 * resets the month counter
	 */
	public void resetMonth();
	/**
	 * equals method
	 * @param title
	 * @return true if matching title
	 */
	public boolean equals(String title);
	
}
