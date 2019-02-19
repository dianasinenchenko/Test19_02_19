package com.example.diana.menutest1.places;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.example.diana.menutest1.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

/**
 * Created by Diana on 19.05.2018.
 */

public class MapsM extends FragmentActivity implements OnStreetViewPanoramaReadyCallback, GoogleMap.OnMarkerClickListener,
        OnMapReadyCallback, GoogleMap.InfoWindowAdapter, GoogleMap.OnInfoWindowClickListener {
    private GoogleMap mMap;
    private static final LatLng SAN_FRAN = new LatLng(50.016071, 36.247077);
    private static final LatLng SAN_FRAN2 = new LatLng(50.004267, 36.235581);
    private static final LatLng SAN_FRAN3 = new LatLng(50.003419, 36.224863);
    private static final LatLng SAN_FRAN4 = new LatLng(50.000329, 36.226880);
    private static final LatLng SAN_FRAN5 = new LatLng(50.000115, 36.224691);
    private static final LatLng SAN_FRAN6 = new LatLng(50.000115, 36.224691);

    private static final LatLng  SY_FR = new LatLng(50.013467, 36.224345);


    /* CameraPosition.fromLatLngZoom(new LatLng(49.990797, 36.224059), 13f),
            CameraPosition.fromLatLngZoom(new LatLng(49.990086, 36.230754), 17f),
            CameraPosition.fromLatLngZoom(new LatLng(49.986705, 36.232936), 17f),
            CameraPosition.fromLatLngZoom(new LatLng(49.987021, 36.191476), 17f),
            CameraPosition.fromLatLngZoom(new LatLng(50.013467, 36.224973), 17f)*/




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



  /*
     StreetViewPanoramaFragment streetViewPanoramaFragment =
                (StreetViewPanoramaFragment) getFragmentManager()
                        .findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);

*/


/*

        super.onCreate(savedInstanceState);
        setContentView(R.layout.street);

        StreetViewPanoramaFragment streetViewPanoramaFragment =
                (StreetViewPanoramaFragment) getFragmentManager()
                        .findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);

        */

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;



        // Create a LatLngBounds that includes Australia.
        //      LatLngBounds Kharkiv = new LatLngBounds(
        //       new LatLng(49.9529, 36.1169), new LatLng(49.9397, 36.4588));

// Set the camera to the greatest possible zoom level that includes the
// bounds
        //  mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(Kharkiv, 0));



        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SAN_FRAN, (float) 15.0));


        Marker s2 =    mMap.addMarker(new MarkerOptions().position(SAN_FRAN).title("Парк Горького"));

        Marker s3 =    mMap.addMarker(new MarkerOptions().position(SAN_FRAN2).title("Площадь Свободы"));
        Marker s4 =    mMap.addMarker(new MarkerOptions().position(SAN_FRAN3).title("Зоопарк"));
        Marker s5 =    mMap.addMarker(new MarkerOptions().position(SAN_FRAN4).title("Дильфинарий"));
        Marker s6 =    mMap.addMarker(new MarkerOptions().position(SAN_FRAN5).title("Ботанический Сад"));
        Marker s7 =    mMap.addMarker(new MarkerOptions().position(SAN_FRAN6).title("Ботанический Сад"));



        LatLng sydney = new LatLng(38, -110);
        LatLng sydney1 = new LatLng(12, -100);
        LatLng sydney2 = new LatLng(38, -90);

        mMap.addMarker(new MarkerOptions().position(SAN_FRAN).title("Marker Test"));

        //   mMap.addGroundOverlay();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SAN_FRAN));
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker Test2"));
        //  mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        Marker s1 = mMap.addMarker(new MarkerOptions().position(sydney1).title("Marker Test3").snippet("fjdfh \n").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        //   setContentView(R.layout.street);


        mMap.addMarker(new MarkerOptions().position(sydney2).title("Marker Test4"));


        mMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) this);



        PolylineOptions rectOptions = new PolylineOptions()
                .add(new LatLng(50.016071, 36.247077))
                .add(new LatLng(50.004267, 36.235581))  // North of the previous point, but at the same longitude
                .add(new LatLng(50.003419, 36.224863))  // Same latitude, and 30km to the west
                .add(new LatLng(50.000329, 36.226880))  // Same longitude, and 16km to the south
                .add(new LatLng(50.000115, 36.224691))
                .add(new LatLng(50.000115, 36.224691))
                .color(Color.BLUE); // Closes the polyline.

// Get back the mutable Polyline
        Polyline polyline = mMap.addPolyline(rectOptions);


    }


    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama panorama) {


        panorama.setPosition(SY_FR);


        panorama.setPanningGesturesEnabled(true);
        panorama.setUserNavigationEnabled(true);
        panorama.setZoomGesturesEnabled(true);
        panorama.setStreetNamesEnabled(true);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Integer clickCount = (Integer) marker.getTag();

        // Check if a click count was set, then display the click count.
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this,
                    marker.getTitle() +
                            " has been clicked " + clickCount + " times.",
                    Toast.LENGTH_SHORT).show();


        }


        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false;
    }


    @Override
    public View getInfoWindow(Marker marker) {

        return null;
    }


    @Override
    public View getInfoContents(Marker marker) {

        return null;


    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }
}
