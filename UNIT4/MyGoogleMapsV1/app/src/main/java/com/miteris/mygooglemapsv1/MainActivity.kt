package com.miteris.mygooglemapsv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.miteris.mygooglemapsv1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mylocation()
        createPolylines()
    }

    private fun createPolylines(){
        val polylineOptions = PolylineOptions()
            .add(LatLng(40.419173113350965,-3.705976009368897))
            .add(LatLng( 40.4150807746539, -3.706072568893432))
            .add(LatLng( 40.41517062907432, -3.7012016773223873))
            .add(LatLng( 40.41713105928677, -3.7037122249603267))
            .add(LatLng( 40.41926296230622,  -3.701287508010864))
            .add(LatLng( 40.419173113350965, -3.7048280239105225))
            .add(LatLng(40.419173113350965,-3.705976009368897))
            .width(25f)
            .color(ContextCompat.getColor(this, R.color.kotlin))

        val polyline = mMap.addPolyline(polylineOptions)

        val pattern = listOf(
            Dot(), Gap(10F), Dash(50F), Gap(10F)
        )
        polyline.pattern = pattern

        polyline.isClickable = true
        mMap.setOnPolylineClickListener { changeColor(it) }
    }

    fun changeColor(polyline: Polyline){
        val color = (0..3).random()
        when(color){
            0 -> polyline.color = ContextCompat.getColor(this, R.color.red)
            1 -> polyline.color = ContextCompat.getColor(this, R.color.yellow)
            2 -> polyline.color = ContextCompat.getColor(this, R.color.green)
            3 -> polyline.color = ContextCompat.getColor(this, R.color.blue)
        }
    }

    private fun mylocation() {
        mMap.setMinZoomPreference(6.0f)
        mMap.setMaxZoomPreference(15.5f)

        // Marcamos Madrid
        val madrid = LatLng(40.417, -3.702)
        mMap.addMarker(
            MarkerOptions()
                .position(madrid)
                .title("Madrid")
                .snippet("Población: 6.825.005 personas")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLng(madrid))

        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                madrid, 15.5f
            )
        )
    }

}