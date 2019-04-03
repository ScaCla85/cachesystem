package jcs.testproject.cachesystem;

import java.io.Serializable;
import java.util.Date;

public class Album implements Serializable {
	   private Integer id;
	   private String artist;
	   private String title;

	   public Album() {
	   }

	   public Album( Integer id, String artist, String title ) {
	     this.id = id;
	     this.artist = artist;
	     this.title = title;
	   }

	   public Integer getId() {
	     return id;
	   }

	   public void setId( Integer id ) {
	     this.id = id;
	   }

	   public String getArtist() {
	     return artist;
	   }

	   public void setArtist( String artist ) {
	     this.artist = artist;
	   }

	   public String getTitle() {
	     return title;
	   }

	   public void setTitle( String title ) {
	     this.title = title;
	   }

	   public String toString() {
	     return artist + ": " + title;
	   }
	}
