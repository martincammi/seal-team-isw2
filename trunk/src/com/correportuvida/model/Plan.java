package com.correportuvida.model;

import java.util.List;

import com.correportuvida.model.runner.RunnerProfile;
import com.correportuvida.model.training.Training;

public class Plan {

	//TODO: para que necesitamos esto?
	private int _id;
	private String _name;

	/* Essential attributes (cannot be changed once created) */
	private final RunnerProfile _profile;
	private final List<Training> _trainings;
	
	//TODO: este es el que deberiamos usar
	public Plan(String name, RunnerProfile profile, List<Training> trainings)
	{
		_name = name;
		_profile = profile;
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
