package com.correportuvida.activities;

import android.app.Activity;
import android.content.Intent;

public class ActivityController {
	public static void OpenActivity(Activity sender, Class<?> classToOpen)
	{
		Intent intent = new Intent(sender, classToOpen);
    	sender.startActivity(intent);
	}
}
