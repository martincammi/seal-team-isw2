package com.correportuvida.model;

import com.correportuvida.model.base.Distance;
import com.correportuvida.model.base.TimeLapse;
import com.correportuvida.model.base.Velocity;

public class Phase {
	private String _name;
	private TimeLapse _lapse;
	private Velocity _maxSpeed;
	private Velocity _minSpeed;
	private int _phaseNumber;

	public static Phase getDummyPhase()
	{
		return new Phase("Fase 1", new TimeLapse(3600, TimeLapse.SECONDS), new Velocity(Distance.FiveKM, TimeLapse.ONE_HOUR), new Velocity(Distance.TwoKM, TimeLapse.ONE_HOUR), 1);
	}
	
	public Phase(String name, TimeLapse lapse, Velocity maxSpeed, Velocity minSpeed, int phaseNumber){
		_name = name;
		_lapse = lapse;
		_maxSpeed = maxSpeed;
		_minSpeed = minSpeed;
		_phaseNumber = phaseNumber;
	}
	
	public String getName() {
		return _name;
	}
	
	public TimeLapse getTimeLapse() {
		return _lapse;
	}
	
	public Velocity getMaxSpeed() {
		return _maxSpeed;
	}
	
	public Velocity getMinSpeed() {
		return _minSpeed;
	}
	
	public int getPhaseNumber() {
		return _phaseNumber;
	}
}
