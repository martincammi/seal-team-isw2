package com.correportuvida.model;

import java.util.List;

import com.correportuvida.model.training.Training;

public class Plan {

	private final String _name;
	private final List<Training> _trainings;
	
	public Plan(String name, List<Training> trainings)
	{
		_name = name;
		_trainings = trainings;
	}
	
	public List<Training> getTrainings()
	{
		return _trainings;
	}
	
	public String getName() {
		return _name;
	}

}
