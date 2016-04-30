@@ -1,262 +0,0 @@
package Database;

import java.io.File;
import java.sql.Timestamp;
import java.util.Calendar;

/**
* @author Jaime Burchette
* This class is to give the concrete implementation of the song interface, which
*  is to model the songs that are to be pulled from the database after being added
*
*/
public class Song implements SongIF  {
	/*The name of the song*/
	private String title;
	/*The name of the artist*/
	private String artist;
	/*The year the song was released*/
	private int year;
	/*The mp3 file for the song*/
	private File songFile;
	/*The file for the picture*/
	private File picture;
	/*The song's id from the database*/
	private int id;
	/*The counter that counts how many times the song has been played
	  * in the last week*/
	public int weekCounter;
	/*Number of times the song has been played this month*/
	private int monthCounter;
	/*the date the songs was added to the jukebox*/
	private Timestamp dateAdded;

	/**
	* Constructors for the song class
	*/
	public Song(String title, String artist, int year, File songFile, File picture){
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.songFile = songFile;
		this.picture = picture;
		weekCounter = 0;
		monthCounter = 0;
		Calendar calendar = Calendar.getInstance();
		dateAdded = new Timestamp(calendar.getTimeInMillis());
	}

	protected Song(String title, String artist, File songFile, File picture){
		this(title, artist, 0, songFile, picture);
	}

	protected Song(String title, String artist, int year, File songFile){
		this(title, artist, year, songFile, null);
	}

	protected Song(String title, String artist, File songFile){
		this(title, artist, 0, songFile, null);
	}

	/**
	* Returns the title of the song
	* @return the title of the song
	*/
	@Override
	public String getTitle() {
		return title;
	}

	/**
	* Returns the name of the artist
	* @return the name of the artist
	*/
	@Override
	public String getArtist() {
		return artist;
	}

	/**
	* Returns the year the song was released
	* @return the year field
	*/
	@Override
	public int getYear() {
		return year;
	}

	/**
	* Returns the song file
	* @return the songFile field
	*/
	@Override
	public File getSongFile() {
		return songFile;
	}

	/**
	* Returns the file for the picture
	*@return the picture field
	*/
	@Override
	public File getPicture() {
		return picture;
	}

	/**
	*Returns the id for the song in the database
	*@return the id feild
	*/
	@Override
	public int getId() {
		return id;
	}

	/**
	*
	*@return the number of times the song has been played in the last week
	*/
	@Override
	public int getWeekCount() {
		return weekCounter;
	}

	/**
	* 
	*@return the number of times the song has been played in the last month
	*/
	@Override
	public int getMonthCount() {
		return monthCounter;
	}

	/**
	* 
	*@return the date that the song was added to the database
	*/
	@Override
	public long getDateAdded(){
		return dateAdded.getTime();
	}

	/**
	* Sets the title of the song
	* @param the new title for the song
	*/
	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	* Sets the artist of the song
	*@param the new artist for the song
	*/
	@Override
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	* Sets the release year of the song
	*@param year the new year for the song
	*/
	@Override
	public void setYear(int year) {
		this.year = year;
	}

	/** 
	* Sets the song file for the song
	* @param songFile the new song file
	*/
	@Override
	public void setSongFile(File songFile) {
		this.songFile = songFile;
	}

	/**
	* Set the picture file for this song
	*@param picture the new picture file for the song
	*/
	@Override
	public void setPicture(File picture) {
		this.picture = picture;
	}

	/**
	* Sets the id for the song from the database
	* @param id the new id 
	*/
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/**
	*Sets the week count of the song
	*@param weekCounter the new number for the plays in the last week
	*/
	@Override
	public void setWeekCount(int weekCounter) {
		this.weekCounter = weekCounter;
	}

	/**
	*Sets the number of times this song has played the last month
	*
	*/
	@Override
	public void setMonthCount(int monthCounter) {
		this.monthCounter = monthCounter;
	}

	/*
	* Add to both counts of the song
	*
	*/
	@Override
	public void addCount(){
		weekCounter++;
		monthCounter++;
	}

	/**
	* Resets the week counter to zero
	*
	*/
	@Override
	public void resetWeek(){
		weekCounter = 0;
	}

	/**
	* Resets the month counter to zero
	*
	*/
	@Override
	public void resetMonth(){
		monthCounter = 0;
	}

	/**
	* Checks to see if two songs are the same by title
	* @param title the title to check by
	*/
	@Override
	public boolean equals(String title) {
		if(title.equals(this.title)){
			return true;
		}
		else{
			return false;
		}
	}







}