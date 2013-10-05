package com.correportuvida.adapters;

import com.correportuvida.model.Phase;

public class PhaseAdapter {
	private final Phase _phase;
	
	public PhaseAdapter(Phase phase){
		_phase = phase;
	}
	
	@Override
	public String toString(){
		return Integer.toString(_phase.getPhaseNumber());
	}
}
