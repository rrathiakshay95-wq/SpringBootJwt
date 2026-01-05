package com.example.demo.alien;

public class Alien {
	
	
	private int id ;
	private String name;
	private String planet;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Alien(int id, String name, String planet) {
		super();
		this.id = id;
		this.name = name;
		this.planet = planet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlanet() {
		return planet;
	}
	public void setPlanet(String planet) {
		this.planet = planet;
	}

}
