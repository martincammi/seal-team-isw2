package com.correportuvida.model;

import java.util.List;

public class Training {
	private List<Fase> _fases;
	private String _name;
	
	
	public List<Fase> getFases() {
		return _fases;
	}
	
	public Training (String name, List<Fase> fases){
		_name = name;
		int listSize = fases.size();
		for(int i=0; i<listSize ; i ++){
			this._fases.add(fases.get(i));
		}
		
	}
	
	public void setFases(List<Fase> fases) {
		this._fases = fases;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	
}
