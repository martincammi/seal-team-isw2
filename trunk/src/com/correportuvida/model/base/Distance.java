package com.correportuvida.model.base;

public class Distance {
	
	public static final String METERS = "mts";
	public static final String KILOMETERS = "km";

	public static final Distance TwoKM = new Distance(2,KILOMETERS);
	public static final Distance FiveKM = new Distance(5,KILOMETERS);
	
	
	private final float _value;
	private final String _unit;
	
	public Distance(float value, String unit) {
		_value = value;
		_unit = unit;
	}
	
	public float getValue() {
		return _value;
	}

	public String getUnit() {
		return _unit;
	}
	
}
