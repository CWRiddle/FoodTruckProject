package com.skilldistillery.app;

public class FoodTruck {
	
	private String name;
	private String foodType;
	private int rating;
	private int id;
	private static int numTrucks = 0;
	
	FoodTruck(){
		setId(numTrucks);
	}
	
	FoodTruck(String name, String foodType, int rating){
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		setId(numTrucks);
	}
	
	static void listExistingFoodTrucks(FoodTruck[] foodTrucks){
		
		String x = foodTrucks[0].getName();
		
		for(int i=0; i<numTrucks; i++) {
			//System.out.println(foodTrucks[i].getName());
			x = foodTrucks[i].getName();
			if(x.length() > 0) {
				toString(foodTrucks[i]);
			}
			else
				continue;
				//toString(foodTrucks[i]);
		}
		
	}
	
	static void findAverageRating(FoodTruck[] foodTrucks) {
		double sum = 0;
		
		for (int i=0; i<foodTrucks.length; i++) {
			sum += foodTrucks[i].getRating();
		}
		double average = (sum / foodTrucks.length);
		System.out.printf("The average rating of all food trucks is %.2f%n", average);
		
		//return average;
		
		
//	for one version
//		int sum = 0;
//		double average;
//		
//		for(int i=0; i < foodTrucks.length; i++) {
//			sum += foodTrucks[i].getRating();
//		}
//		average = (double) sum / foodTrucks.length;
//		return average;
	}
	
	static void findHighestRated(FoodTruck[] foodTrucks) {
		
		FoodTruck highestRated = foodTrucks[0];
		for(int i=0; i<foodTrucks.length; i++) {
			if(foodTrucks[i].getRating() > highestRated.getRating()) {
				highestRated = foodTrucks[i];
			}
		}
		System.out.println("The highest rated food truck is: ");
		FoodTruck.toString(highestRated);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFoodType() {
		return foodType;
	}
	
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	private void setId(int numTrucks) {
		this.id = numTrucks;
		this.numTrucks++;
	}
	
	public int getId() {
		return id;
	}
	
	private static void toString(FoodTruck foodTruck) {
		System.out.println("Food Truck ID: " + foodTruck.getId());
		System.out.println("\tName: " + foodTruck.getName());
		System.out.println("\tType of Food: " + foodTruck.getFoodType());
		System.out.println("\tRating: " + foodTruck.getRating());
		System.out.println();
	}
}
