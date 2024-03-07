package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.song;
import com.kodnest.tunehub.serviceimpl.SongServiceImpl;

@Controller
public class SongController {
	@Autowired
	SongServiceImpl songService;
	@PostMapping("/addsong")
	public String	addsong(@ModelAttribute song song){
		boolean songStatus = songService.songExists(song.getName());
		if(songStatus==false) {
			songService.addsong(song);
			System.out.println("Song added Sucessfully");
		}
		else {
			System.out.println("Song already exists");
		}

		return "adminhome";


	}
	@GetMapping("/viewsongs")
	public String viewsongs(Model model) {
		List<song> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		
		return "displaysongs";
	}
	@GetMapping("/playsongs")
	public String playsongs(Model model) {
		boolean premium=false;
		if(premium) {
		List<song> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		
		return "displaysongs";
	}else {
		return "subscriptionform";
	}
	}
}

