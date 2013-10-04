package com.correportuvida.model.training;

import java.util.ArrayList;
import java.util.List;

import com.correportuvida.model.runner.RunnerAvailability;
import com.correportuvida.model.runner.RunnerObjective;
import com.correportuvida.model.runner.RunnerProfile;
import com.correportuvida.model.runner.RunnerState;

public class TrainingFactory {
	public List<Training> createTrainings(RunnerProfile profile, RunnerObjective objective, RunnerAvailability availability, RunnerState state){
		List<Training> trainings = new ArrayList<Training>();
		//Todos los entrenamientos disponibles hasta el momento
		trainings.add(createRecreativeTraining(profile, objective, availability, state));
		trainings.add(createFullTraining(profile, objective, availability, state));
		trainings.add(createVelocityTraining(profile, objective, availability, state));
		
		return trainings;
	}
	private Training createVelocityTraining(RunnerProfile profile, RunnerObjective objective, RunnerAvailability availability, RunnerState state) {
		// TODO Auto-generated method stub
		return null;
	}

	private Training createFullTraining(RunnerProfile profile, RunnerObjective objective, RunnerAvailability availability, RunnerState state) {
		// TODO Auto-generated method stub
		return null;
	}

	private Training createRecreativeTraining(RunnerProfile profile, RunnerObjective objective, RunnerAvailability availability, RunnerState state) {
		// TODO Auto-generated method stub
		return null;
	}


}
