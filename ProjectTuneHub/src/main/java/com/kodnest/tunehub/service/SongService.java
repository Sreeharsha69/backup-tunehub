package com.kodnest.tunehub.service;

import java.util.List;

import com.kodnest.tunehub.entity.song;

public interface SongService {
	public String addsong(song song);
	public List<song>fetchAllSongs();

	boolean songExists(String name);
	
	public void updateSong(song song);
	

}
