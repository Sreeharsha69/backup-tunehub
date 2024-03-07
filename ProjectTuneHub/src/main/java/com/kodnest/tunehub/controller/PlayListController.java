package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.PlayList;
import com.kodnest.tunehub.entity.song;
import com.kodnest.tunehub.service.PlayListService;
import com.kodnest.tunehub.service.SongService;

@Controller
public class PlayListController {@Autowired

SongService songService;
@Autowired
PlayListService playListService;
	@GetMapping("/createplaylists")
	public String createPlaylists(Model model) {
		List<song> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		
		return "createplaylists";


	}
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute PlayList playlist) {
		playListService.addplaylist(playlist);
		
		List<song>songList = playlist.getSongs();
		for (song song : songList) {
			song.getPlaylist().add(playlist);
			songService.updateSong(song);
		}
		
		return "adminhome";
		
	}
	
	@GetMapping("/viewplaylist")
	public String viewplaylist(Model model) {
		List<PlayList> songList = playListService.fetchAllPlaylist();
		model.addAttribute("playlist", songList);
		
		return "displayplaylist";
	}
	
}
