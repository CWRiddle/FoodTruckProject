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
	
	public static int getNumTrucks() {
		return numTrucks;
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
	
	public String toString() {
		String result;
		result = "+Food Truck ID: " + this.id + "\n|\tName: " + this.name + "\n|\tFood: " + this.foodType + "\n|\tRating: " + this.rating + "\n|";
		return result;
	}
}
