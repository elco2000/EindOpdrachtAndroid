package com.example.elcoo.blijdorpapp;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.directions.route.Route;
import com.directions.route.RouteException;
import com.directions.route.Routing;
import com.directions.route.RoutingListener;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    private String TAG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        int route = getIntent().getIntExtra("ROUTE", 0);


        mapFragment.getMapAsync(this);



    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {


        int route = getIntent().getIntExtra("ROUTE", 0);
//        SQLiteDatabase blijdorpDB = this.openOrCreateDatabase("blijdorpDB", MODE_PRIVATE, null);

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }
        mMap = googleMap;


        if (route == 0) {
            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(51.928168, 4.444017);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Blijdorp"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 18));
            // Zoom in, animating the camera.
            googleMap.animateCamera(CameraUpdateFactory.zoomIn());
            // Zoom out to zoom level 10, animating with a duration of 2 seconds.
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);

        }

        if (route == 1) {
            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(51.928579, 4.445204);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Blijdorp"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 18));
            // Zoom in, animating the camera.
            googleMap.animateCamera(CameraUpdateFactory.zoomIn());
            // Zoom out to zoom level 10, animating with a duration of 2 seconds.
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);

        }

        if (route == 2) {
            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(51.927852, 4.446774);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Blijdorp"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 18));
            // Zoom in, animating the camera.
            googleMap.animateCamera(CameraUpdateFactory.zoomIn());
            // Zoom out to zoom level 10, animating with a duration of 2 seconds.
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);

        }

        if (route == 3) {
            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(51.925633, 4.449941);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Blijdorp"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 18));
            // Zoom in, animating the camera.
            googleMap.animateCamera(CameraUpdateFactory.zoomIn());
            // Zoom out to zoom level 10, animating with a duration of 2 seconds.
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);

        }
        // 51.928579, 4.445204 Vissen

        final LatLng VISSEN = new LatLng(51.928579, 4.445204);
        final LatLng IJSBEREN = new LatLng(51.927431, 4.444811);
        final LatLng VLINDERS = new LatLng(51.927852, 4.446774);
        final LatLng LEEUWEN = new LatLng(51.928423, 4.450094);
        final LatLng GIRAFFEN = new LatLng(51.925633, 4.449941);
        final LatLng KAMELEN = new LatLng(51.928137, 4.453134);
        final LatLng GORILLAS = new LatLng(51.925087, 4.451513);



        Marker vissen = mMap.addMarker(new MarkerOptions()
                .position(VISSEN)
                .title("Vissen")
                .snippet("Voedertijden: 14:00, 15:00, 16:00"));

        Marker ijsberen = mMap.addMarker(new MarkerOptions()
                .position(IJSBEREN)
                .title("Ijsberen")
                .snippet("Voedertijden: 14:30, 15:30, 16:30"));

        Marker vlinders = mMap.addMarker(new MarkerOptions()
                .position(VLINDERS)
                .title("Vlinders")
                .snippet("Voedertijden: 14:15, 15:15, 16:15"));

        Marker leeuwen = mMap.addMarker(new MarkerOptions()
                .position(LEEUWEN)
                .title("Leeuwen")
                .snippet("Voedertijden: 14:00, 15:00, 16:00"));

        Marker giraffen = mMap.addMarker(new MarkerOptions()
                .position(GIRAFFEN)
                .title("Giraffen")
                .snippet("Voedertijden: 13:30, 14:30, 15:30"));

        Marker kamelen = mMap.addMarker(new MarkerOptions()
                .position(KAMELEN)
                .title("Kamelen")
                .snippet("Voedertijden: 13:15, 14:15, 15:15"));

        Marker gorillas = mMap.addMarker(new MarkerOptions()
                .position(GORILLAS)
                .title("Gorillas")
                .snippet("Voedertijden: 13:20, 14:20, 15:20"));



    }




//    public void getFish(){
//        SQLiteDatabase blijdorpDB = this.openOrCreateDatabase("blijdorpDB", MODE_PRIVATE, null);
//
//
//        Cursor c = blijdorpDB.rawQuery("SELECT * FROM animal WHERE Name = 'vissen'",
//                null);
//        int Column1 = c.getColumnIndex("Name");
//        int Column2 = c.getColumnIndex("Description");
//        c.moveToLast();
//        String Name = c.getString(Column1);
//        String Description = c.getString(Column2);
//
//
//    }
}
