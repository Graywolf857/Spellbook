package com.toltonic;

import java.util.LinkedList;
import java.util.Objects;

public class Wizard{

	private int level;
	private String name;
	private int health;
	private int numberOfSpells;

	private LinkedList<Spell> spellList = new LinkedList<Spell>();

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

	public LinkedList<Spell> getSpellList(){
		return this.spellList;
	}
	public Spell getSpellFromName(String name){
		Spell brick = new Spell();
		brick.setName("error");
		for(Spell spell : this.spellList){
			if(spell.getName().equals(name)){
				return spell;
			}else{
			}
		}
		return brick;
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





	public void addSpellToList(Spell spell){
		spellList.add(spell);
	}

	public void removeSpellFromList(Spell spell){
		spellList.remove(spell);
	}
}
