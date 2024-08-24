package com.VotingSystem.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Profile {
	
	@Id
	private int id;
	
	@Lob
	@Column(name="profile", length=1000000)
	private byte[] image;
	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Profile(int id, byte[] image, String name) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
	}

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", image=" + Arrays.toString(image) + ", name=" + name + "]";
	}

	
	

}
