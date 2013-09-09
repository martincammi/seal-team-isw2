package com.correportuvida.model;

public class Characteristic {

	/* Essential attributes (cannot be changed once created) */
	final double height;
	final double weight;
	
	public Characteristic(double height, double weight) {
		this.height = height;
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	
}
