package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.song;
import com.kodnest.tunehub.repository.SongRepository;
import com.kodnest.tunehub.service.SongService;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	SongRepository songRepository;
	public String addsong(song song) {
		songRepository.save(song);
		return "Song Added Successfully";
		
	}



@Override
public boolean songExists(String name) {
	song song = songRepository.findByName(name);
	if(song==null) {
		return false;
	}
	else {
		return true;
	}
}
public List<song>fetchAllSongs(){
	List<song> songs = songRepository.findAll();
	return songs;
}



@Override
public void updateSong(song song) {
	songRepository.save(song);
	// TODO Auto-generated method stub
	
}
}