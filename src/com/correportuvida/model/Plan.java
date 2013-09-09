package com.correportuvida.model;

public class Plan {

	private int id;
	private String name;

	/* Essential attributes (cannot be changed once created) */
	private final Characteristic characteristic; 
	
	public Plan(String name, double height, double weight) {
		this.name = name;
		this.characteristic = new Characteristic(height, weight);
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Characteristic getCharacteristic() {
		return characteristic;
	}
}
