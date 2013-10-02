package com.correportuvida.model;

import java.util.List;

import com.correportuvida.model.runner.Runner;
import com.correportuvida.model.training.Training;

public class Plan {

	//TODO: para que necesitamos esto?
	private int _id;
	private String _name;

	/* Essential attributes (cannot be changed once created) */
	private final Runner _runner;
	private final List<Training> _trainings;
	
	public Plan(String name, Runner runner, List<Training> trainings)
	{
		_name = name;
		_runner = runner;
		_trainings = trainings;
	}
	
	public List<Training> getTrainings()
	{
		return _trainings;
	}
	
	public int getId(){
		return this._id;
	}

	public String getName() {
		return _name;
	}

}
