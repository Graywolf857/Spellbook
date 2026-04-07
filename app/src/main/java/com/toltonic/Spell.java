package com.toltonic;

public class Spell{

	private int level;
	private int damage;
	private String name;
	private boolean used = false;
	private boolean prepared;
	private boolean requiresPrep;
	private int numberOfUses;
	private boolean isCantrip;

	public Spell(int level, String name, boolean used){
		this.level = level;
		this.name = name;
		this.used = used;
	}

	public Spell(){
		super();
	}

//	METHODS

	public int castSpell(){
		this.used = true;
		return damage;
	}



//	GETTERS

	public int getLevel(){
		return level;
	}

	public String getName(){
		return name;
	}

	public boolean getUsed(){
		return used;
	}

	public boolean getPrepared(){
		return prepared;
	}

	public boolean getRequiresPrep(){
		return requiresPrep;
	}

	public int numberOfUses(){
		return numberOfUses;
	}

	public boolean getIsCantrip(){
		return isCantrip;
	}

	public int getDamage(){
		return damage;
	}






//	SETTERS

	public void setDamage(int damage){
		this.damage = damage;
	}

	public void setUsed(boolean used){
		this.used = used;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public void setLevel(int level){
		this.level = level;
	}

	public void setPrepared(boolean prepared){
		this.prepared = prepared;
	}

	public void setRequiresPrep(boolean requiresPrep){
		this.requiresPrep = requiresPrep;
	}

	public void setNumberOfUses(int numberOfUses){
		this.numberOfUses = numberOfUses;
	}

	public void setIsCantrip(boolean isCantrip){
		this.isCantrip = isCantrip;
	}

}
