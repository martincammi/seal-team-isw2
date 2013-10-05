package com.correportuvida.model;

import java.util.ArrayList;
import java.util.List;

import com.correportuvida.model.base.Distance;
import com.correportuvida.model.base.TimeLapse;
import com.correportuvida.model.base.Velocity;
import com.correportuvida.model.runner.RunnerAvailability;
import com.correportuvida.model.runner.RunnerObjective;
import com.correportuvida.model.runner.RunnerProfile;
import com.correportuvida.model.runner.RunnerState;
import com.correportuvida.model.training.Training;

public class SportsDoctor {
	
	private List<Training> _trainings; 

	public SportsDoctor(RunnerProfile profile, RunnerObjective objective, RunnerAvailability availability, RunnerState state){

		_trainings = createTrainings (profile, objective, availability, state);
	}
	
	private List<Training> createTrainings(RunnerProfile profile, RunnerObjective objective, RunnerAvailability availability, RunnerState state){
		List<Training> trainings = new ArrayList<Training>();

		trainings.add(createRecreativeTraining(profile, objective, availability, state));
		trainings.add(createFullTraining(profile, objective, availability, state));
		trainings.add(createVelocityTraining(profile, objective, availability, state));
		
		return trainings;
	}
	
	public List<Training> getTrainings(){
		return _trainings;
	}
	
	public Training createVelocityTraining(RunnerProfile profile, RunnerObjective objective, RunnerAvailability availability, RunnerState state) {
		List<Phase> phases = new ArrayList<Phase>();
		phases.add(Phase.getDummyPhase());
		return new Training("Velocidad", phases);
	}

	private Training createFullTraining(RunnerProfile profile, RunnerObjective objective, RunnerAvailability availability, RunnerState state) {
		List<Phase> phases = new ArrayList<Phase>();
		phases.add(Phase.getDummyPhase());
		return new Training("De Fondo", phases);
	}

	private Training createRecreativeTraining(RunnerProfile profile, RunnerObjective objective, RunnerAvailability availability, RunnerState state) {
		List<Phase> phases = new ArrayList<Phase>();
		phases.add(Phase.getDummyPhase());
		return new Training("Recreativo", phases);
	}
}
