package com.correportuvida.model.base;

public class Distance {
	
	public static final String METERS = "meters";
	public static final String KILOMETERS = "kilometers";

	public static final Distance FiveKM = new Distance(5,KILOMETERS);
	
	
	private final int _value;
	private final String _unit;
	
	public Distance(int value, String unit) {
		_value = value;
		_unit = unit;
	}

	public int getValue() {
		return _value;
	}

	public String getUnit() {
		return _unit;
	}
	
}
