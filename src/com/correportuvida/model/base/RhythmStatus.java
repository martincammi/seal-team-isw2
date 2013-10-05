package com.correportuvida.model.base;

public class RhythmStatus {

	private final String GOOD = "Vas bien";
	private final String SPEED_UP = "Metele pata";
	private final String SPEED_DOWN = "Bajá un cambio";
	
	public String getRhythm(Velocity minVelocity, Velocity maxVelocity, Velocity currentVelocity){
		
		if(minVelocity.getValue() <= currentVelocity.getValue() && currentVelocity.getValue() <= maxVelocity.getValue()){
			return GOOD;
		}else if(currentVelocity.getValue() < minVelocity.getValue()){
			return SPEED_UP;
		}else if(maxVelocity.getValue() < currentVelocity.getValue() ){
			return SPEED_DOWN;	
		}

		return GOOD;
	}
}
