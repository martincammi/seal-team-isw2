package com.correportuvida.model;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.location.Location;

import com.correportuvida.R;
import com.correportuvida.adapters.VelocityAdapter;
import com.correportuvida.model.base.Distance;
import com.correportuvida.model.base.TimeLapse;
import com.correportuvida.model.base.Velocity;
import com.correportuvida.model.interfaces.Reportable;
import com.correportuvida.services.GoogleMapsService;
import com.correportuvida.util.HexColor;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.PolylineOptions;
/* TODO:
 * encargado de pedirle a google toda la info sobre velocidad y blah
 * 
 * */
public class Navigator {

	private GoogleMapsService _googleMapsService;
	private Marker currentMarker;
	private Location currentLocation;
	private float _distance = 0;
	private Activity _activity;
	private Velocity currentVelocity;
	
	public Navigator(GoogleMapsService googleMapsService, Activity activity) throws Exception{
		_googleMapsService = googleMapsService;
		_activity = activity;
		
		if(!_googleMapsService.servicesConnected()){
			  throw new Exception("The Google map is not correclty initialized");
		}
	}
	
	public void start (Reportable positionVelocityReportable, TimeLapse timeLapse){
		_googleMapsService.startProcessingLocation(positionVelocityReportable, timeLapse);
	}
	
	public Velocity getVelocity()
	{
		return currentVelocity;
	}
	
	public Location getPosition()
	{
		return _googleMapsService.getCurrentLocation();
	}
	
	public Distance getDistanceTraveled() {
		return new Distance(_distance, Distance.METERS);
	}

	public void stopNavigator() {
		_googleMapsService.stopMapRefreshing();
	}
	
	public void updatePosition(){
		
    	Location location = getPosition();

		ArrayList<LatLng> positions = new ArrayList<LatLng>();
    	if (currentMarker != null) {
    		positions.add(currentMarker.getPosition());
    		currentMarker.remove();
    	}
    	
    	  LatLng coordinates = GoogleMapsService.getLatLng(location);
          
          positions.add(coordinates);
          
          if (positions.size() > 1){
  			drawPrimaryLinePath(positions);
  		}
        
        currentMarker = _googleMapsService.drawMarker(coordinates, "Exactas is cool", getCorrePorTuVidaIcon(), "Posicion actual");

        _googleMapsService.moveToPositionInGoogleMap(currentMarker);
        
        float lastDistance = 0; 
  		if (currentLocation != null){
  			lastDistance = location.distanceTo(currentLocation); 
  			_distance += lastDistance;
  		}
  		currentLocation = location;
  		
  		int currentTimeInSeconds = _googleMapsService.getTimeLapseForUpdate().getLapse() / 1000;
  		
  		TimeLapse currentTimeLapseInSeconds = new TimeLapse(currentTimeInSeconds, TimeLapse.SECONDS);
  		
  		currentVelocity = new Velocity(new Distance(lastDistance, Distance.METERS), currentTimeLapseInSeconds);
	}
	
	private void drawPrimaryLinePath( ArrayList<LatLng> locationsToDraw )
    {
        if( !_googleMapsService.servicesConnected()){
            return;
        }

        if(locationsToDraw.size() < 2){
            return;
        }

        PolylineOptions options = new PolylineOptions();

        options.color( Color.parseColor(HexColor.BLUE) );
        options.width( 5 );
        options.visible( true );

        for (LatLng locRecorded : locationsToDraw){
            options.add(locRecorded);
        }

        //googleMap.addPolyline( options );
        _googleMapsService.addPolyLine(options);
    }
	
	private BitmapDescriptor getCorrePorTuVidaIcon() {
		return BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher);
	}

}
