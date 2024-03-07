package com.kodnest.tunehub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.PlayList;
@Service
public interface PlayListService {

	public  void addplaylist(PlayList playlist) ;

	public List<PlayList>fetchAllPlaylist();

	}


