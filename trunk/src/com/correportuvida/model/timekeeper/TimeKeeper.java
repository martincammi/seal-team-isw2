package com.correportuvida.model.timekeeper;

import java.util.Timer;
import java.util.TimerTask;

import com.correportuvida.model.interfaces.*;
import com.correportuvida.model.base.*;

public class TimeKeeper {
	
	private final Timer _timer;
	
	private TimeLapse _lapseTime;
	private final Reportable _reportable;

	private final int NO_START_DELAY = 0;
	private final int MS = 1000;
		
	/**
	 * Once the TimeKeeper is initialized begins to tic tac.
	 * @param notificable
	 * @param lapseTime
	 */
	public TimeKeeper(Reportable notificable, TimeLapse lapseTime)
	{
		_timer = new Timer();
		_lapseTime = lapseTime; 
		_reportable = notificable;
		_timer.schedule( new TimeKeeperTask(), NO_START_DELAY , _lapseTime.getLapse() * MS);
	}
	
	public void modifyTimeLapse(TimeLapse lapse)
	{
		_timer.schedule( new TimeKeeperTask(), lapse.getLapse() * MS);
	}

	class TimeKeeperTask extends TimerTask
	{
		@Override
		public void run() {
			_reportable.report();
		}
	}
}
