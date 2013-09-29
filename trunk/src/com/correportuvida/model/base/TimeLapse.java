package com.correportuvida.model.base;

public class TimeLapse {
	private final int _lapseInSeconds;
	
	public TimeLapse(int lapseInSeconds)
	{
		_lapseInSeconds = lapseInSeconds;
	}
	
	public int getSecondsQuantity()
	{
		return _lapseInSeconds;
	}
}
