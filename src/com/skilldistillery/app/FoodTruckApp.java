package com.skilldistillery.app;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.println("This program will allow you to input the information and ratings for various food trucks.");
		System.out.print("How many food trucks would you like to enter?: ");
		int foodTruckAmt = kb.nextInt();
		
		FoodTruck[] foodTruck = new FoodTruck[foodTruckAmt];

		initFoodTrucks(foodTruck, kb);
		menu(kb, foodTruck);
		
		System.out.println("Program ended.");
		kb.close();
		
	}
	
	public static void menu(Scanner kb, FoodTruck[] foodTruck) {
		boolean looping = true;
		
		while(looping) {
			
			System.out.println("1. List all existing food trucks.");
			System.out.println("2. See the average rating of food trucks.");
			System.out.println("3. Display the highest-rated food truck.");
			System.out.println("4. Quit the program.");
			
			int input = kb.nextInt();
			
			switch(input) {
			case 1:
				FoodTruck.listExistingFoodTrucks(foodTruck);
				//listExistingFoodTrucks();
				break;
			case 2:
				FoodTruck.findAverageRating(foodTruck);
				//System.out.println(FoodTruck.findAverageRating(foodTruck));
				//findAverageRating();
				break;
			case 3:
				FoodTruck.findHighestRated(foodTruck);
				//System.out.println(FoodTruck.findHighestRated(foodTruck).getRating());
				//findHighestRated();
				break;
			case 4:
				looping = false;
				break;
			}
		}
	}
	
	public static void initFoodTrucks(FoodTruck foodTruck[], Scanner kb) {
		
		String inputStr;
		int inputInt;
		boolean looping = true;
		
		while(looping) {
			for(int i=0; i<foodTruck.length; i++) {
				System.out.print("Enter name of food truck #" + (i+1) + ": ");
				inputStr = kb.next();
				if(inputStr.equals("quit")) {
					looping = false;
					break;
				}
				else {
					foodTruck[i] = new FoodTruck();	//initialized new food truck
					foodTruck[i].setName(inputStr);
				}
				System.out.print("What type of food did they serve?: ");
				inputStr = kb.next();
				foodTruck[i].setFoodType(inputStr);
				System.out.print("How many stars out of 5 do you give it?: ");
				inputInt = kb.nextInt();
				foodTruck[i].setRating(inputInt);
				kb.nextLine();
			}
			looping = false;
		}
		
	}
}
