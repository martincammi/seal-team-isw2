package com.correportuvida.model;

import junit.framework.TestCase;

import com.correportuvida.model.base.TimeLapse;
import com.correportuvida.model.runner.RunnerAvailability;
import com.correportuvida.model.runner.RunnerBuilder;
import com.correportuvida.model.runner.RunnerObjective;
import com.correportuvida.model.runner.RunnerProfile;
import com.correportuvida.model.runner.RunnerState;

public class TestTimeKeeperTest extends TestCase {

	public void testTimeKeeper(){
		
		RunnerProfile profile = RunnerBuilder.buildDefaultProfile();
        RunnerObjective objective = RunnerBuilder.buildDefaultObjective();
        RunnerAvailability availability = RunnerBuilder.buildDefaultAvailability();
        RunnerState state = RunnerBuilder.buildDefaultState();
        
		TimeLapse timePhase = new TimeLapse(1, TimeLapse.SECONDS);
		TimeLapse timePositionVelocity = new TimeLapse(3, TimeLapse.SECONDS);
		//Trainer trainer = new Trainer(timePhase, timePositionVelocity);
		Trainer trainer = Trainer.createInitialInstance(new SportsDoctor(profile, objective, availability, state));
		boolean breakMotherfucker = true;
		assertFalse(breakMotherfucker);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
