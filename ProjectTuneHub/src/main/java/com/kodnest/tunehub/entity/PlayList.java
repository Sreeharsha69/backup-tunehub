package com.kodnest.tunehub.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class PlayList {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	int id;
	String name;
	@ManyToMany
	List<song> songs;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<song> getSongs() {
		return songs;
	}
	public void setSongs(List<song> songs) {
		this.songs = songs;
	}
	public PlayList(int id, String name, List<song> songs) {
		super();
		this.id = id;
		this.name = name;
		this.songs = songs;
	}
	public PlayList() {
		super();
	}
	@Override
	public String toString() {
		return "PlayList [id=" + id + ", name=" + name  + "]";
	}


}
