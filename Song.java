package Database;

import java.io.File;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Holds all data related to a single song
 * @author Jamie Burchette, Grant Brown, Zacharay Larenzo
 * @version 4/29/16
 */
public class Song implements SongIF  {

	//Info about song
	private String title;
	private String artist;
	private int year;
	private File songFile;
	private File picture;
	
	//Id in table
	private int id;
	
	//Counters for popularity
	public int weekCounter;
	private int monthCounter;
	
	//Time song was created
	private Timestamp dateAdded;

	/**
	 * Initiates the song object
	 * @param title title of song
	 * @param artist artist who performed song
	 * @param year year song was released
	 * @param songFile File that contains song
	 * @param picture image file to accompany song
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

	/**
	 * Initiates the song object
	 * @param title title of song
	 * @param artist artist who performed song
	 * @param songFile File that contains song
	 * @param picture image file to accompany song
	 */
	protected Song(String title, String artist, File songFile, File picture){
		this(title, artist, 0, songFile, picture);
	}

	/**
	 * Initiates the song object
	 * @param title title of song
	 * @param artist artist who performed song
	 * @param year year song was released
	 * @param songFile File that contains song
	 */
	protected Song(String title, String artist, int year, File songFile){
		this(title, artist, year, songFile, null);
	}

	/**
	 * Initiates the song object
	 * @param title title of song
	 * @param artist artist who performed song
	 * @param songFile File that contains song
	 */
	protected Song(String title, String artist, File songFile){
		this(title, artist, 0, songFile, null);
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getArtist() {
		return artist;
	}

	@Override
	public int getYear() {
		return year;
	}

	@Override
	public File getSongFile() {
		return songFile;
	}

	@Override
	public File getPicture() {
		return picture;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public int getWeekCount() {
		return weekCounter;
	}

	@Override
	public int getMonthCount() {
		return monthCounter;
	}

	@Override
	public long getDateAdded(){
		return dateAdded.getTime();
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public void setSongFile(File songFile) {
		this.songFile = songFile;
	}

	@Override
	public void setPicture(File picture) {
		this.picture = picture;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setWeekCount(int weekCounter) {
		this.weekCounter = weekCounter;
	}

	@Override
	public void setMonthCount(int monthCounter) {
		this.monthCounter = monthCounter;
	}

	/**
	 * Increases counters when song is played
	 */
	@Override
	public void addCount(){
		weekCounter++;
		monthCounter++;
	}

	/**
	 * Allows resetting at end of week
	 */
	@Override
	public void resetWeek(){
		weekCounter = 0;
	}

	/**
	 * Allows resetting at end of month
	 */
	@Override
	public void resetMonth(){
		monthCounter = 0;
	}

	/**
	 * Checks if a title is the same as this song's title
	 * @param title the title being checked
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
