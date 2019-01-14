package com.example.elcoo.blijdorpapp;

import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

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

        SQLiteDatabase blijdorpDB = this.openOrCreateDatabase("blijdorpDB", MODE_PRIVATE, null);

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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(51.928168, 4.444017);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Blijdorp"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,20));
        // Zoom in, animating the camera.
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(20), 2000, null);

        // 51.928579, 4.445204 Vissen

        getFish();

    }

    public void getFish(){
        SQLiteDatabase blijdorpDB = this.openOrCreateDatabase("blijdorpDB", MODE_PRIVATE, null);
        final LatLng VISSEN = new LatLng(51.928579, 4.445204);

        Cursor c = blijdorpDB.rawQuery("SELECT * FROM animal WHERE Name = 'vissen'",
                null);
        int Column1 = c.getColumnIndex("Name");
        int Column2 = c.getColumnIndex("Description");
        c.moveToLast();
        String Name = c.getString(Column1);
        String Description = c.getString(Column2);

        Marker melbourne = mMap.addMarker(new MarkerOptions()
                .position(VISSEN)
                .title(Name)
                .snippet("Voedertijden: 14:00, 15:00, 16:00"));
    }
}
