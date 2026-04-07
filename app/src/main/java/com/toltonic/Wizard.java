package com.toltonic;

public class Wizard{

	private int level;
	private String name;
	private int health;
	private int numberOfSpells;

	public Wizard(){
		super();
	}

//	METHODS
	
	public void damageHealth(int damage){
		this.health = health - damage;
	}


//	GETTERS

	public int getLevel(){
		return level;
	}

	public String getName(){
		return name;
	}

	public int getHealth(){
		return health;
	}

	public int getNumberOfSpells(){
		return numberOfSpells;
	}


//	SETTERS

	public void setLevel(int newLevel){
		this.level = newLevel;
	}

	public void setName(String newName){
		this.name = newName;
	}

	public void setHealth(int health){
		this.health = health;
	}

	public void setNumberOfSpells(int amount){
		this.numberOfSpells = amount;
	}
}
