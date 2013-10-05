package com.correportuvida.model.base;

public class TimeLapse {
	
	public static final String MILISECONDS = "miliseconds";
	public static final String SECONDS = "s"; 
	public static final String HOUR = "h";
	
	public static final TimeLapse ONE_HOUR = new TimeLapse(1, HOUR);
	
	private int _lapse;
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
	
	public void convertToSeconds(){
		
		if(_unit.equals(MILISECONDS)){
			_lapse = _lapse / 1000;
		}
		
	}
}
