package com.correportuvida.model.runner;

import com.correportuvida.model.base.WeeklyFrecuence;

public class RunnerBuilder {
	public static Runner buildDefaultRunner()
	{
		int timesAWeek = 2;
		float height = (float)1.8;
		float weight = 70;
		RunnerAvailability availability = new RunnerAvailability(new WeeklyFrecuence(timesAWeek));
		RunnerObjective objective = new RunnerObjective(); //TODO: incomplete
		RunnerProfile profile = new RunnerProfile(height, weight);
		RunnerState state = new RunnerState();//TODO: incomplete
		
		Runner defaultRunner = new Runner(profile, objective, availability, state);
		return defaultRunner;
	}
}
