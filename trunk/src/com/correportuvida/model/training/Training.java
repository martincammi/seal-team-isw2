package com.correportuvida.model.training;

import java.util.List;

import com.correportuvida.model.Phase;
import com.correportuvida.model.Plan;

/**
 * @author martincammi
 *
 */
public class Training {
	
	private final String _name;
	private Plan _plan; 
	private final List<Phase> _phases;
	
	public Training(String name, List<Phase> phases)
	{
		_name = name;
		_phases = phases;
	}

	public void setPlan(Plan plan){
		_plan = plan;
	}
	
	public String getName() {
		return _name;
	}

	public List<Phase> getPhases() {
		return _phases;
	}

	public Plan getPlan() {
		return _plan;
	}
	
}
