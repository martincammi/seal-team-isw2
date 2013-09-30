package com.correportuvida.model;

import java.util.List;

import com.correportuvida.model.runner.Runner;
import com.correportuvida.model.training.Training;
import com.correportuvida.model.training.TrainingFactory;

public class SportsDoctor {
	public Plan createPlan(String name, Runner runner){
		List<Training> trainings = (new TrainingFactory()).createTrainings(runner);
		Plan plan = new Plan(name, runner.profile, trainings);
		return plan;
	}
}
