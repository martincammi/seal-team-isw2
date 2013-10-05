package com.correportuvida.model;

import java.util.ArrayList;

import android.graphics.Color;
import android.location.Location;

import com.correportuvida.R;
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
	private float distance = 0;
	
	public Navigator(GoogleMapsService googleMapsService) throws Exception{
		_googleMapsService = googleMapsService;
		
		if(!_googleMapsService.servicesConnected()){
			  throw new Exception("The Google map is not correclty initialized");
		}
	}
	
	public void start (Reportable positionVelocityReportable, TimeLapse timeLapse){
		_googleMapsService.updateCurrentLocation(positionVelocityReportable, timeLapse);
	}
	
	public Velocity getVelocity()
	{
		float speed = getPosition().getSpeed();
		return new Velocity(new Distance(speed, Distance.METERS), new TimeLapse(1,TimeLapse.HOUR));
	}
	
	public Location getPosition()
	{
		return _googleMapsService.getCurrentLocation();
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

          //googleMapService.moveToPositionInGoogleMapWithEffect(currentMarker);
          _googleMapsService.moveToPositionInGoogleMap(currentMarker);
          
  		if (currentLocation != null){
  			distance += location.distanceTo(currentLocation);
  		}
  		currentLocation = location;
  		
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
