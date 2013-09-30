package com.correportuvida.adapters;

import com.correportuvida.model.Plan;

public class PlanVisualAdapter {
	private Plan _plan;
	public PlanVisualAdapter(Plan plan)
	{
		_plan = plan;
	}
	
	@Override
	public String toString(){
		return _plan.getName();
	}
}
