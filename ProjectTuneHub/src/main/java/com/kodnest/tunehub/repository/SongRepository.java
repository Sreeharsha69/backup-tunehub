package com.kodnest.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.tunehub.entity.song;

public interface SongRepository extends JpaRepository<song, Integer> {

	public song findByName(String name);
	

}