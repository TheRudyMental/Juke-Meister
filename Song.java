package control;

import java.io.File;
import java.sql.Timestamp;
import java.util.Calendar;

public class Song implements SongIF {

	private String title;
	private String artist;
	private int year;
	private File songFile;
	private File picture;
	private int id;
	private int weekCounter;
	private int monthCounter;
	private Timestamp dateAdded;


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

	@Override
	public void addCount(){
		weekCounter++;
		monthCounter++;
	}

	@Override
	public void resetWeek(){
		weekCounter = 0;
	}

	@Override
	public void resetMonth(){
		monthCounter = 0;
	}

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
