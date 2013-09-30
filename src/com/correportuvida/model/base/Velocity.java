package com.correportuvida.model.base;

public class Velocity {
	private final int _kmXHour;
	
	//TODO: no se cual es la forma correcta de hacer esto
	public Velocity(int velocityInKmByHour)
	{
		_kmXHour = velocityInKmByHour;
	}
	
	public int getKmXHour()
	{
		return _kmXHour;
	}
}
