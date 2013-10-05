package com.correportuvida.adapters;

import java.text.DecimalFormat;

import com.correportuvida.model.base.Distance;

public class DistanceAdapter {
	private final Distance _distance;
	
	public DistanceAdapter(Distance distance)
	{
		_distance = distance;
	}
	
	@Override
	public String toString()
	{
		return new DecimalFormat("###.##").format(_distance.getValue()) + " " + _distance.getUnit();
	}
}
