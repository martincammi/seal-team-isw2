package com.correportuvida.model;

public class Fase {
	private String _name;
	private int _timePeriod;
	private int _maxSpeed;
	private int _minSpeed;
	private int _faseCount;

	public Fase(String name, int timePeriod, int maxSpeed, int minSpeed, int faseCount){
		this._name = name;
		this._timePeriod = timePeriod;
		this._maxSpeed = maxSpeed;
		this._minSpeed = minSpeed;
		this._faseCount = faseCount;
	}
	
	public String get_name() {
		return _name;
	}
	
	public void set_name(String _name) {
		this._name = _name;
	}
	
	public int get_timePeriod() {
		return _timePeriod;
	}
	
	public void set_timePeriod(int _timePeriod) {
		this._timePeriod = _timePeriod;
	}
	
	public int get_maxSpeed() {
		return _maxSpeed;
	}
	
	public void set_maxSpeed(int _maxSpeed) {
		this._maxSpeed = _maxSpeed;
	}
	
	public int get_minSpeed() {
		return _minSpeed;
	}
	
	public void set_minSpeed(int _minSpeed) {
		this._minSpeed = _minSpeed;
	}
	
	public int get_faseCount() {
		return _faseCount;
	}
	
	public void set_faseCount(int _faseCount) {
		this._faseCount = _faseCount;
	}

}