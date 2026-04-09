package com.toltonic;

import java.util.LinkedList;
import java.util.Objects;
import java.io.FileWriter;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;


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

	public void clearSpellList(){
		this.spellList.clear();
	}

	public void saveWizardToFile(Wizard wizard){
		ObjectMapper objectMapper = new ObjectMapper();

		try{
		objectMapper.writeValue(new File("src/main/resources/wizard.json"), wizard);
		}catch( Exception e){
			System.out.println("There was a problem saving your file");
		}
	}
}
