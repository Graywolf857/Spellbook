package com.toltonic;

import java.util.Scanner;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.LinkedList;

public class Main{
	public static void main(String[] args){
		boolean programOn = true;

		Wizard grayson = new Wizard();

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
				print("'search' to search for a spell by name");
				print("'attack' to see a list of prepared spells that you can cast");
				print("'cast' + spell' to cast a spell");
				print("'q'   to quit");

			}else if(Objects.equals(input, "q")){

				programOn = false;
				
				clearScreen();

			}else if(Objects.equals(input, "new")){
				Wizard wizard = new Wizard();
				print("What is your wizard's name?");

				String name = scanner.nextLine();

				wizard.setName(name);

				print("What is his level?");

				int level = scanner.nextInt();

				wizard.setLevel(level);

				print("What is his starting health?");

				int health = scanner.nextInt();

				wizard.setHealth(health);

				print("You have successfully created your wizard " + wizard.getName() + " level " + wizard.getLevel());

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

				grayson.addSpellToList(spell);
				print("You have successfully added " + spell.getName() + " to your spellbook");

				waitForEnter();
				clearScreen();
			}else if(Objects.equals(input, "search")){
				print("What is the name of the spell you would like to search for?");

				String name = scanner.nextLine();

				Spell spell = grayson.getSpellFromName(name);

				if(Objects.equals(spell.getName(),"error")){
					print("This spell is not on your list");
				}else{

					print(spell.getName() + " is in your database and has a damage of " + spell.getDamage());
				}

				waitForEnter();
				clearScreen();
			}else if(Objects.equals(input, "attack")){
				LinkedList<Spell> spellList = grayson.getSpellList();

				clearScreen();

				print("Here is a list of your prepared spells:");

				for(Spell spell : spellList){
					if(spell.getPrepared() == true){
						System.out.println(spell.getName());
					}
				}

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

	
}
