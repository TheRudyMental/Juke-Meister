package control;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import Database.SongDatabaseIF;
import Database.SongIF;
import control.SongFactory;

public class DB_Controller implements SongDatabaseIF {

	private String framework = "embedded";

	private String driver = "org.apache.derby.jdbc.EmbeddedDriver";

    private String protocol = "jdbc:derby:";

    public ArrayList<SongIF> songs;

    String songDB = "JukeMeisterDBateam";

    Connection conn = null;

    int records;

    public DB_Controller(){
    	songs = new ArrayList<SongIF>();
        this.createTable();
        songs = selectAll(true);
    }

    public void add(SongIF newSong){
    	this.insert(newSong);
        songs.add(newSong);
    }

    public void addRecord(String title, String artist, int year, File song, File picture){
    	SongIF s = SongFactory.makeSong(title, artist, year, song, picture);
        this.add(s);
    }

    public void remove(int index){

    	if(index < 0 || index >= this.getSize() ) return;

    	SongIF s = songs.get(index);
    	this.remove(s);
    }

    public void updateRecord(SongIF s){
    	this.update(s);
    }

	public SongIF getSong(int index) {
		if(index > songs.size() || index < 0)
			throw new IllegalArgumentException("Out of bounds!");
		if(songs != null)
			return songs.get(index);
		else
			return null;
	}

	public int getSize() {
		if(songs != null)
			return songs.size();
		return 0;
	}

    public  SongIF getSongByTitle(String title){
        if(title != null){

            for (int i = 0;i < songs.size(); i++){
                if (songs.get(i).equals(title))
                        return songs.get(i);
            }
        }

        return null;
    }

    private void loadDriver() {
        try {
            Class.forName(driver).newInstance();
            System.out.println("Loaded the appropriate driver");
        }
        catch (ClassNotFoundException cnfe) {
            System.err.println("\nUnable to load the JDBC driver " + driver);
            System.err.println("Please check your CLASSPATH.");
            cnfe.printStackTrace(System.err);
        } catch (InstantiationException ie) {
            System.err.println(
                        "\nUnable to instantiate the JDBC driver " + driver);
            ie.printStackTrace(System.err);
        } catch (IllegalAccessException iae) {
            System.err.println(
                        "\nNot allowed to access the JDBC driver " + driver);
            iae.printStackTrace(System.err);
        }
    }

    public Connection connect() {

    	boolean state = false;
    	loadDriver();

    	try{
	        Properties props = new Properties();

	    	conn = DriverManager.getConnection(protocol + songDB + ";create=true", props);

	        System.out.println("Connected to and created database " + songDB);

    	}
    	catch(SQLException ex){
           	System.out.println("Error connecting to database");
        }

    	return null;
    }

    public void closeDB(){
    	 if (framework.equals("embedded"))
         {
             try
             {
               DriverManager.getConnection("jdbc:derby:;shutdown=true");
             }
             catch (SQLException se)
             {
                 if (( (se.getErrorCode() == 50000)
                         && ("XJ015".equals(se.getSQLState()) ))) {
                     System.out.println("Derby shut down normally");
                 } else {
                     System.err.println("Derby did not shut down normally");
                     se.printStackTrace();
                 }
             }

             conn = null;
         }
    }

    public void createTable() {

    	 if (conn == null)
    		   connect();

	     try{
	    	Statement st = conn.createStatement();
	    	records++;

	    	st.execute("CREATE TABLE filestorage ( "
					 +  "id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1 ),"
					 + " title VARCHAR(150) NOT NULL ,"
	                 + " artist VARCHAR (150) NOT NULL ,"
	                 + " yearo INTEGER ,"
	                 + " songFile VARCHAR(255) NOT NULL,"
	                 + " picture VARCHAR(255) NOT NULL,"
	                 + " weekCounter INTEGER ,"
	                 + " MonthCounter INTEGER )");

	    	   conn.commit();

	    	   System.out.println("Created table location");
	    }
	    catch(SQLException ex){

	    	       	System.out.println("Error creating table:" + ex.getMessage());
	    }
	    finally{
	    	   closeDB();
	    }
    }

   private void insert(SongIF s) {

	   if (conn == null)
		   connect();

	   try
	   {
		   PreparedStatement psInsert;
		   psInsert= conn.prepareStatement(  "insert into filestorage(title, artist, yearo, songFile, picture) values ( ?, ?, ?, ?, ?)");

		   psInsert.setString(1, s.getTitle());
	       psInsert.setString(2, s.getArtist());
	       psInsert.setInt(3, s.getYear());
	       psInsert.setString(4, s.getSongFile().toString());
	       psInsert.setString(5, s.getPicture().toString());
	       psInsert.executeUpdate();

	       conn.commit();
	       System.out.println("Record inserted");

	   }
       catch(SQLException ex){
       	System.out.println("Error inserting: " + ex.getMessage());
       }
	   finally{
    	   closeDB();
       }

   }

   public void update(SongIF s) {

	   if (conn == null)
		   connect();

	   try{
		   PreparedStatement psUpdate;
		   psUpdate= conn.prepareStatement(  "UPDATE filestorage SET title=?,  artist=?, yearo=?, songFile=?, picture=? WHERE id = " + s.getId());

		   psUpdate.setString(1, s.getTitle());
	       psUpdate.setString(2, s.getArtist());
	       psUpdate.setInt(3, s.getYear());
	       psUpdate.setString(4, s.getSongFile().toString());
	       psUpdate.setString(5, s.getPicture().toString());

	       psUpdate.executeUpdate();

	       conn.commit();
	       System.out.println("Record updated");
	   }
       catch(SQLException ex){
       	System.out.println("Error updating record: " + ex.getMessage() + " ::" + s.getDateAdded());
       }
	   finally{
    	   closeDB();
       }


   }

   public void remove(SongIF s){

	   if (conn == null)
		   connect();

	   try{
		   PreparedStatement psUpdate;
		   psUpdate= conn.prepareStatement(  "DELETE FROM filestorage WHERE id = " + s.getId());
		   psUpdate.executeUpdate();
	       conn.commit();
	       System.out.println("Record removed:");
	       this.songs.remove(s);
	   }
       catch(SQLException ex){
       	System.out.println("Error removing record:" + ex.getMessage());
       }
	   finally{
    	   closeDB();
       }

   }

   public void removeByTitle(String title){

	   if (conn == null)
		   connect();

	   try{
		   SongIF s = this.getSongByTitle(title);
		   PreparedStatement psUpdate;
		   psUpdate= conn.prepareStatement(  "DELETE FROM filestorage WHERE id = " + s.getId());
		   psUpdate.executeUpdate();
	       conn.commit();
	       System.out.println("Record removed:");
	       this.songs.remove(s);
	   }
       catch(SQLException ex){
       	System.out.println("Error removing record:" + ex.getMessage());
       }
	   finally{
    	   closeDB();
       }

   }

   public void dropTable(){

	   if (conn == null)
		   connect();

	   try{
	       Statement st =conn.createStatement();
		   st.execute("drop table location");


	       conn.commit();
	       System.out.println("Record updated");
	   }
       catch(SQLException ex){
       	System.out.println("Error removing record.");
       }
	   finally{
    	   closeDB();
       }

   }

	public void loadAll(){
		 selectAll(true);
	}

	private ArrayList<SongIF> selectAll(boolean clear) {

	   if (conn == null)
		   connect();

	     ResultSet rs = null;
	     try{
	   		Statement st =conn.createStatement();

	   		rs = st.executeQuery( "SELECT * FROM filestorage ORDER BY title");

	   		if (clear) songs.clear();

	        while ( rs.next()){
	        	SongIF s =  SongFactory.makeSong(rs.getString("title"),
												        	rs.getString("artist"),
												        	rs.getInt("yearo"),
												        	new File(rs.getString("songFile")),
												        	new File(rs.getString("picture"))
												        	);

	        	songs.add(s);
	        }
        }
        catch(SQLException ex){
        	System.out.println("Error performing selection: " + ex.getMessage());
        }
	    finally{
	    	   closeDB();
	    }

	   return songs;
   }

   public ArrayList<SongIF> selectSongs(String where, boolean clear) {


	   String query = "SELECT id, title, artist, song FROM filestorage  WHERE " + where;


	   System.out.println("SELECT: " + query);


	   if (conn == null)
		   connect();

	     ResultSet rs = null;
	     try{
	   		Statement st =conn.createStatement();

	   		rs = st.executeQuery( query);

	   		if (clear) songs.clear();

	        while ( rs.next()){
	        	SongIF s = SongFactory.makeSong(rs.getString("title"),
	        			                                   rs.getString("artist"),
	        			                                   rs.getInt("yearo"),
	        			                                   new File(rs.getString("songFile")),
	        			                                   new File(rs.getString("picture")));


	        	this.songs.add(s);
	        }
	        System.out.println("Selection " + where + " complete");
        }
        catch(SQLException ex){
        	System.out.println("Error performing selection: " +ex.getMessage());
        }
	    finally{
	    	   closeDB();
	    }

	   return songs;
   }
}

