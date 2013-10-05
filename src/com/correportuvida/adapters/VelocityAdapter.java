package com.correportuvida.adapters;

import java.text.DecimalFormat;

import com.correportuvida.model.base.Velocity;

public class VelocityAdapter {
	private final Velocity _velocity;
	
	public VelocityAdapter(Velocity velocity)
	{
		_velocity = velocity;
	}
	
	@Override
	public String toString()
	{
		return new DecimalFormat("##.##").format(_velocity.getValue()) + _velocity.getUnit();
	}

}
