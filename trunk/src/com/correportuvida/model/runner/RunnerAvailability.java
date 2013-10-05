package com.correportuvida.model.runner;

import com.correportuvida.model.base.WeeklyFrequence;

public class RunnerAvailability {
	
	private final WeeklyFrequence _frecuence;
	
	public RunnerAvailability(WeeklyFrequence frecuence)
	{
		_frecuence = frecuence;
	}
	
	public int getNumberOfDaysAweek()
	{
		return _frecuence.getTimesAWeek();
	}
}
