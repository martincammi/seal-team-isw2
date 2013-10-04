package com.correportuvida.model.training;

import java.util.List;

import com.correportuvida.model.Phase;

public class Training {
	
	private final String _name;
	private final List<Phase> _phases;
	
	public Training(String name, List<Phase> phases)
	{
		_name = name;
		_phases = phases;
	}

	public String getName() {
		return _name;
	}

	public List<Phase> getPhases() {
		return _phases;
	}
	
}
