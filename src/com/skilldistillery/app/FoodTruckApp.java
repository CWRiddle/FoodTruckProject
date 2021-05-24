package com.skilldistillery.app;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("| This program will allow you to input the information and ratings for various food trucks. |");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("|                                                                                            ");
		System.out.println("+--------------------------------------------------------------------------------------------");
		System.out.print("| How many food trucks would you like to enter?: ");
		int foodTruckAmt = kb.nextInt();
		System.out.println("+--------------------------------------------------------------------------------------------");
		
		FoodTruck[] foodTruck = new FoodTruck[foodTruckAmt];
//
		String inputStr;
		int inputInt;
		boolean looping = true;
		
		while(looping) {
			for(int i=0; i<foodTruck.length; i++) {
				System.out.print("\n| Enter name of food truck #" + (i+1) + ": ");
				kb.next();
				inputStr = kb.nextLine();
				if(inputStr.equals("quit")) {
					looping = false;
					break;
				}
				else {
					foodTruck[i] = new FoodTruck();	//initialized new food truck
					foodTruck[i].setName(inputStr);
				}
				System.out.print("| What type of food did they serve?: ");
				inputStr = kb.nextLine();
				foodTruck[i].setFoodType(inputStr);
				System.out.print("| How many stars out of 5 do you give it?: ");
				inputInt = kb.nextInt();
				foodTruck[i].setRating(inputInt);
				kb.nextLine();
			}
			looping = false;
		}
//
		looping = true;
		
		while(looping) {
			System.out.println();
			System.out.println("+--------------------------------------------+");
			System.out.println("|                    MENU                    |");
			System.out.println("+--------------------------------------------+");
			System.out.println("| 1.  List all existing food trucks.         |");
			System.out.println("| 2.  See the average rating of food trucks. |");
			System.out.println("| 3.  Display the highest-rated food truck.  |");
			System.out.println("| 4.  Quit the program.                      |");
			System.out.println("+--------------------------------------------+");
			System.out.print("+ Enter Selection -> ");
			
			int input = kb.nextInt();
			
			switch(input) {
			case 1:
				System.out.println();
				System.out.println("+----------------------------------+");
				System.out.println("| LIST OF ALL EXISTING FOOD TRUCKS |");
				System.out.println("+----------------------------------+");
				for(int i=0; i<FoodTruck.getNumTrucks(); i++) {
					if(foodTruck[i].getName().length() > 0) {
						System.out.println(foodTruck[i].toString());
					}
					else
						continue;
				}	
				break;
			case 2:
				System.out.println();
				System.out.println("+----------------------------------+");
				System.out.println("|          AVERAGE RATING          |");
				System.out.println("+----------------------------------+");
				
				double sum = 0;
				
				for (int i=0; i<FoodTruck.getNumTrucks(); i++) {
					sum += foodTruck[i].getRating();
				}
				double average = (sum / FoodTruck.getNumTrucks());
				System.out.printf("| -> The average rating of all food trucks is %.2f%n.", average);
				break;
			case 3:
				System.out.println();
				System.out.println("+----------------------------------+");
				System.out.println("|     HIGHEST RATED FOOD TRUCK     |");
				System.out.println("+----------------------------------+");
				FoodTruck highestRated = foodTruck[0];
				for(int i=0; i<FoodTruck.getNumTrucks(); i++) {
					if(foodTruck[i].getRating() > highestRated.getRating()) {
						highestRated = foodTruck[i];
					}
				}
				System.out.println("| -> The highest rated food truck is: ");
				System.out.println("+----------------------------------+");
				System.out.println(highestRated.toString());
				break;
			case 4:
				looping = false;
				break;
			}
		}
		
		
		System.out.println("Program ended.");
		kb.close();
		
	}
}
