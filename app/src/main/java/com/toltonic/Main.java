package com.toltonic;

import java.util.Scanner;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.LinkedList;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;


public class Main{
	public static void main(String[] args){
		boolean programOn = true;

		clearScreen();

		print("Loading saves");

		Wizard mainWizard = readFromSave();

		//Wizard grayson = new Wizard();


		Scanner scanner = new Scanner(System.in);

		clearScreen();

		print("Welcome to your spellbook");

		while(programOn){


			print("What would you like to do? (Type 'help' to see options, and 'q' to quit.)");

			String input = scanner.next();

			// To make sure it doesn't skip the next nextLines
			scanner.nextLine();

			if(Objects.equals(input, "help")){
				print("'new' to create a new wizard and start a new book");
				print("'add' to add a new spell");
				print("'book' to print all of the spells in your spell book");
				print("'search' to search for a spell by name");
				print("'attack' to see a list of prepared spells that you can cast");
				print("'cast' + spell' to cast a spell");
				print("'remove' to remove a spell");
				print("'rest' to rest");
				print("'q'   to quit");
				

			}else if(Objects.equals(input, "q")){

				programOn = false;
				
				clearScreen();

			}else if(Objects.equals(input, "new")){
				print("Are you sure you want to make a new wizard?\nThis will delete your old save file! (y/n)");

				String yon = scanner.nextLine();

				if(Objects.equals(yon, "y")){

					mainWizard.clearSpellList();

					print("What is your new wizard's name?");

					String name = scanner.nextLine();

					mainWizard.setName(name);

					print("What is his level?");

					int level = scanner.nextInt();

					mainWizard.setLevel(level);

					print("What is his starting health?");

					int health = scanner.nextInt();

					mainWizard.setHealth(health);

					print("You have successfully created your wizard " + mainWizard.getName() + " level " + mainWizard.getLevel());

					mainWizard.saveWizardToFile(mainWizard);
				}else{
					print("I guess this guy has some sentimental value");
					print("If you want to have mutiple saves, you can copy and paste the wizard.json file into another place and hot swap them");
				}

				

				waitForEnter();
				clearScreen();
			}else if(Objects.equals(input, "test")){
				Wizard wizard = new Wizard();

				Spell magicMissile = new Spell();

				magicMissile.setName("Magic Missile");

				print(magicMissile.getName());

				wizard.addSpellToList(magicMissile);

				LinkedList<Spell> spellList = wizard.getSpellList();

				Spell spell = spellList.get(0);

				print(spell.getName());

				String spellRequestName = scanner.nextLine();

				Spell lit = wizard.getSpellFromName(spellRequestName);

				print(lit.getName());

			}else if(Objects.equals(input, "add")){

				boolean preped = true;

				print("What is the name of your spell?");
				String name = scanner.nextLine();
				print("How much damage does it do?");
				int damage = scanner.nextInt();
				print("Do you want to prepare the spell now? (y/n)");
				String prep = scanner.next();
				if(Objects.equals(prep, "y")){
					 preped = true;
				}else{
					 preped = false;
				}

				Spell spell = new Spell();

				spell.setName(name);
				spell.setDamage(damage);
				spell.setPrepared(preped);

				mainWizard.addSpellToList(spell);
				print("You have successfully added " + spell.getName() + " to your spellbook");

				mainWizard.saveWizardToFile(mainWizard);

				waitForEnter();
				clearScreen();
			}else if(Objects.equals(input, "search")){
				print("What is the name of the spell you would like to search for?");

				String name = scanner.nextLine();

				Spell spell = mainWizard.getSpellFromName(name);

				if(Objects.equals(spell.getName(),"error")){
					print("This spell is not on your list");
				}else{

					print(spell.getName() + " is in your database and has a damage of " + spell.getDamage());
				}

				waitForEnter();
				clearScreen();
			}else if(Objects.equals(input, "attack")){
				LinkedList<Spell> spellList = mainWizard.getSpellList();

				clearScreen();

				print("Here is a list of your prepared spells:");

				for(Spell spell : spellList){
					if(spell.getPrepared() == true){
						System.out.println(spell.getName());
					}
				}

			}else if(Objects.equals(input, "remove")){
				print("What spell would you like to remove?");

				String spellName = scanner.nextLine();

				Spell spell = mainWizard.getSpellFromName(spellName);

				mainWizard.removeSpellFromList(spell);

				print("Removed " + spell.getName() + " from your book");

				mainWizard.saveWizardToFile(mainWizard);

				waitForEnter();
				clearScreen();
			}else if(Objects.equals(input, "book")){
				LinkedList<Spell> spellList = mainWizard.getSpellList();

				clearScreen();

				print("Here are all your spells");

				for(Spell spell : spellList){
					System.out.println(spell.getName() + "\nDamage: " + spell.getDamage() + " Prepared: " + spell.getPrepared());
				}
			}else if(Objects.equals(input, "rest")){
				LinkedList<Spell> spellList = mainWizard.getSpellList();

				clearScreen();

				for(Spell spell : spellList){
					if(spell.getPrepared() == true){
						spell.setPrepared(false);
					}
				}

				print("You have rested and your health has been reset");

				mainWizard.saveWizardToFile(mainWizard);

				waitForEnter();
				clearScreen();
			}

		}
}

	public static void print(String string){
		System.out.println(string);
	}

	public static void clearScreen(){
		System.out.print("\033\143");
	}

	public static void waitForEnter(){
		Scanner scanner = new Scanner(System.in);

		print("Press enter to continue");

		scanner.nextLine();
	}

	public static Wizard readFromSave(){
		ObjectMapper objectMapper = new ObjectMapper();

		Wizard wizard = new Wizard();

		try{
			wizard = objectMapper.readValue(new File("src/main/resources/wizard.json"), Wizard.class);
		}catch( Exception e){
			print("You have no previous save");
		}
		return wizard;
	}
}
