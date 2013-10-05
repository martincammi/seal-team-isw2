package com.correportuvida.model.base;

public class Velocity {
	
	public static final String SECONDS = "seconds"; 
	
	private final Distance _distance;
	private final TimeLapse _timeLapse;
	
	public Velocity(Distance distance, TimeLapse timeLapse)
	{
		_distance = distance;
		_timeLapse = timeLapse;
	}
	
	public float getValue()
	{
		return _distance.getValue() / _timeLapse.getLapse();
	}
	
	public String getUnit(){
		return _distance.getUnit() + "/" + _timeLapse.getUnit();
	}
}
