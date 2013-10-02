package com.correportuvida.model.runner;

public class Runner {
	private final RunnerProfile _profile; 
	private final RunnerObjective _objective; 
	private final RunnerAvailability _availavility;
	private final RunnerState _state;
	
	public Runner(RunnerProfile profile, RunnerObjective objective, RunnerAvailability availability, RunnerState state)
	{
		_profile = profile;
		_objective = objective;
		_availavility = availability;
		_state = state;
	}
	
	public RunnerProfile getProfile()
	{
		return _profile;
	}
}
