package com.correportuvida.model.runner;

public abstract class RunnerState {
	
	private final String _name;
	private final int _value;
	
	public RunnerState(String name, int value)
	{
		_name = name;
		_value = value;
	}
	
	public String getName() {
		return _name;
	}
	public int getValue() {
		return _value;
	}
}
