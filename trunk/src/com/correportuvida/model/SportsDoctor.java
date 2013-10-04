package com.correportuvida.model;

import java.util.List;

import com.correportuvida.model.runner.RunnerAvailability;
import com.correportuvida.model.runner.RunnerObjective;
import com.correportuvida.model.runner.RunnerProfile;
import com.correportuvida.model.runner.RunnerState;
import com.correportuvida.model.training.Training;
import com.correportuvida.model.training.TrainingFactory;

public class SportsDoctor {
	public Plan createPlan(String planName, RunnerProfile profile, RunnerObjective objective, 
						   RunnerAvailability availability, RunnerState state){
		List<Training> trainings = (new TrainingFactory()).createTrainings(profile, objective, availability, state);
		Plan plan = new Plan(planName, trainings);
		return plan;
	}
}
