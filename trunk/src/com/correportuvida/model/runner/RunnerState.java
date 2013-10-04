package com.correportuvida.model.runner;

public abstract class RunnerState {
	
	private String _name;
	private int value;
	
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
