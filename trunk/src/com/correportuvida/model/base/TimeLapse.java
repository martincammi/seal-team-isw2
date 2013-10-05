package com.correportuvida.model.base;

public class TimeLapse {
	
	public static final String SECONDS = "seconds"; 
	public static final String HOUR = "hour";
	
	public static final TimeLapse ONE_HOUR = new TimeLapse(1, HOUR);
	
	private final int _lapse;
	private final String _unit;
	
	public TimeLapse(int lapse, String unit)
	{
		_lapse = lapse;
		_unit = unit;
	}
	
	public int getLapse()
	{
		return _lapse;
	}

	public String getUnit() {
		return _unit;
	}
}
