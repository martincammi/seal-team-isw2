package com.correportuvida.model.runner;

public class RunnerProfile {
	/* Essential attributes (cannot be changed once created) */
	private final double height;
	private final double weight;
	
	public RunnerProfile (double height, double weight) {
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
