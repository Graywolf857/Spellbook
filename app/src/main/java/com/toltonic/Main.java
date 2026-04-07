package com.toltonic;

import java.util.Scanner;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main{
	public static void main(String[] args){
		boolean programOn = true;

		Scanner scanner = new Scanner(System.in);

		clearScreen();

		while(programOn){


			print("Welcome to your spellbook\nWhat would you like to do? (Type 'help' to see options, and 'q' to quit.)");

			String input = scanner.next();

			// To make sure it doesn't skip the next nextLines
			scanner.nextLine();

			if(Objects.equals(input, "help")){
				print("'new' to create a new wizard and start a new book");
				print("'add' to add a new spell");
				print("'cast + spell' to cast a spell");
				print("'q'   to quit");

			}else if(Objects.equals(input, "q")){

				programOn = false;

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
