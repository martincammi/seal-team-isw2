package com.correportuvida.model.runner;

import com.correportuvida.model.base.WeeklyFrecuence;

public class RunnerAvailability {
	
	private final WeeklyFrecuence _frecuence;
	
	public RunnerAvailability(WeeklyFrecuence frecuence)
	{
		_frecuence = frecuence;
	}
	
	public int getNumberOfDaysAweek()
	{
		return _frecuence.getTimesAWeek();
	}
}
