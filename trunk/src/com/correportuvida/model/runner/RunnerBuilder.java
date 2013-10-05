package com.correportuvida.model.runner;

import com.correportuvida.model.base.Distance;
import com.correportuvida.model.base.WeeklyFrequence;

public class RunnerBuilder {
	public static RunnerProfile buildDefaultProfile()
	{
		float height = (float)1.8;
		float weight = 70;
		return new RunnerProfile(height, weight);
	}
	
	public static RunnerObjective buildDefaultObjective(){
		return new RunnerObjective(Distance.FiveKM); 
	}
	
	public static RunnerAvailability buildDefaultAvailability(){
		int timesAWeek = 2;
		return new RunnerAvailability(new WeeklyFrequence(timesAWeek));
	}
	
	public static RunnerState buildDefaultState(){
		return new RunnerState("TODO", -1){};//TODO: Next Sprint
	}
}
