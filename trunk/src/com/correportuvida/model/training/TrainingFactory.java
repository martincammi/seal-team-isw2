package com.correportuvida.model.training;

import java.util.ArrayList;
import java.util.List;

import com.correportuvida.model.runner.Runner;

public class TrainingFactory {
	public List<Training> createTrainings(Runner runner){
		List<Training> trainings = new ArrayList<Training>();
		//Todos los entrenamientos disponibles hasta el momento
		trainings.add(createRecreativeTraining(runner));
		trainings.add(createFullTraining(runner));
		trainings.add(createVelocityTraining(runner));
		
		return trainings;
	}
	private Training createVelocityTraining(Runner runner) {
		// TODO Auto-generated method stub
		return null;
	}

	private Training createFullTraining(Runner runner) {
		// TODO Auto-generated method stub
		return null;
	}

	private Training createRecreativeTraining(Runner runner) {
		// TODO Auto-generated method stub
		return null;
	}


}
