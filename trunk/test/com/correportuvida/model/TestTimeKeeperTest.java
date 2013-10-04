package com.correportuvida.model;

import junit.framework.TestCase;

import com.correportuvida.model.base.TimeLapse;

public class TestTimeKeeperTest extends TestCase {

	public void testTimeKeeper(){
		
		TimeLapse timePhase = new TimeLapse(1);
		TimeLapse timePositionVelocity = new TimeLapse(3);
		//Trainer trainer = new Trainer(timePhase, timePositionVelocity);
		Trainer trainer = new Trainer(new SportsDoctor());
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
