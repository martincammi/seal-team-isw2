package com.correportuvida.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.correportuvida.model.training.Training;

public class Plan {

	private final String _name;
	private final Map<String, Training> _trainings;
	
	public Plan(String name, List<Training> trainings)
	{
		_name = name;
		_trainings = loadTrainings(trainings);
	}
	
	public List<Training> getTrainings()
	{
		return new ArrayList<Training>(_trainings.values());
	}
	
	public String getName() {
		return _name;
	}

	public Training getTraining(String trainingName){
		return _trainings.get(trainingName);
	}
	
	private Map<String, Training> loadTrainings(List<Training> trainings){
		
		Map<String, Training> trainingMap = new HashMap<String, Training>();
		
		for (Training training : trainings) {
			training.setPlan(this);
			trainingMap.put(training.getName(), training);
		}
		
		return trainingMap;
	}
	
}
