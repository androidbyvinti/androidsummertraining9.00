package com.bmpl.userlocation

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private var mLastUpdateTime: String? = null

    private val TAG = "MainActivity"

    private val UPDATE_INTERVAL_IN_MILLISECONDS: Long = 10000

    private val FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS: Long = 5000

    private val REQUEST_CHECK_SETTINGS = 100

    // google api --> to fetch longitude and lattitude
    private var mFusedLocationClient: FusedLocationProviderClient? = null


    private var mSettingsClient: SettingsClient? = null
    private var mLocationRequest: LocationRequest? = null
    private var mLocationSettingsRequest: LocationSettingsRequest? = null
    private var mLocationCallback: LocationCallback? = null
    private var mCurrentLocation: Location? = null

    // boolean flag to toggle the ui
    private var mRequestingLocationUpdates: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        restoreValuesFromBundle(savedInstanceState)
    }

    private fun init() {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)


        mSettingsClient = LocationServices.getSettingsClient(this)

        mLocationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
                mCurrentLocation = locationResult.lastLocation
                mLastUpdateTime = DateFormat.getTimeInstance().format(Date())

                updateLocationUI()
            }
        }

        mRequestingLocationUpdates = false

        mLocationRequest = LocationRequest()
        mLocationRequest!!.interval = UPDATE_INTERVAL_IN_MILLISECONDS
        mLocationRequest!!.fastestInterval = FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS
        mLocationRequest!!.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        val builder = LocationSettingsRequest.Builder()
        builder.addLocationRequest(mLocationRequest!!)
        mLocationSettingsRequest = builder.build()
    }

    private fun restoreValuesFromBundle(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("is_requesting_updates")) {
                mRequestingLocationUpdates = savedInstanceState.getBoolean("is_requesting_updates")
            }

            if (savedInstanceState.containsKey("last_known_location")) {
                mCurrentLocation = savedInstanceState.getParcelable("last_known_location")
            }

            if (savedInstanceState.containsKey("last_updated_on")) {
                mLastUpdateTime = savedInstanceState.getString("last_updated_on")
            }
        }

        updateLocationUI()
    }


    private fun updateLocationUI() {
        if (mCurrentLocation != null) {
            location_result.text = "Lat: " + mCurrentLocation!!.latitude + ", " +
                    "Lng: " + mCurrentLocation!!.longitude

            location_result.alpha = 0f
            location_result.animate().alpha(1f).duration = 300

            location_result.text = "Last updated on: " + mLastUpdateTime!!
        }

        toggleButtons()
    }

    public override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putBoolean("is_requesting_updates", mRequestingLocationUpdates!!)
        outState.putParcelable("last_known_location", mCurrentLocation)
        outState.putString("last_updated_on", mLastUpdateTime)

    }

    private fun toggleButtons() {
        if (mRequestingLocationUpdates!!) {
            btnStartUpdate.isEnabled = false
            btnStopUpdate.isEnabled = true
        } else {
            btnStartUpdate.isEnabled = true
            btnStopUpdate.isEnabled = false
        }
    }

    @SuppressLint("MissingPermission")
    private fun startLocationUpdates() {
        mSettingsClient!!
                .checkLocationSettings(mLocationSettingsRequest)
                .addOnSuccessListener(this) {
                    Log.i(TAG, "All location settings are satisfied.")

                    Toast.makeText(applicationContext, "Started location updates!", Toast.LENGTH_SHORT).show()

                    mFusedLocationClient!!.requestLocationUpdates(mLocationRequest,
                            mLocationCallback, Looper.myLooper())

                    updateLocationUI()
                }
                .addOnFailureListener(this) { e ->
                    val statusCode = (e as ApiException).statusCode
                    when (statusCode) {
                        LocationSettingsStatusCodes.RESOLUTION_REQUIRED -> {
                            Log.i(TAG, "Location settings are not satisfied. Attempting to upgrade " + "location settings ")
                            try {
                                // Show the dialog by calling startResolutionForResult(), and check the
                                // result in onActivityResult().
                                val rae = e as ResolvableApiException
                                rae.startResolutionForResult(this@MainActivity, REQUEST_CHECK_SETTINGS)
                            } catch (sie: IntentSender.SendIntentException) {
                                Log.i(TAG, "PendingIntent unable to execute request.")
                            }

                        }
                        LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
                            val errorMessage = "Location settings are inadequate, and cannot be " + "fixed here. Fix in Settings."
                            Log.e(TAG, errorMessage)

                            Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_LONG).show()
                        }
                    }

                    updateLocationUI()
                }
    }

    fun startLocationButtonClick(view : View) {
                        mRequestingLocationUpdates = true
                        startLocationUpdates()
                    }


    fun stopLocationButtonClick(view : View) {
        mRequestingLocationUpdates = false
        stopLocationUpdates()
    }

    private fun stopLocationUpdates() {
        mFusedLocationClient!!
                .removeLocationUpdates(mLocationCallback)
                .addOnCompleteListener(this) {
                    Toast.makeText(applicationContext, "Location updates stopped!", Toast.LENGTH_SHORT).show()
                    toggleButtons()
                }
    }

    fun showLastKnownLocation(view : View) {
        if (mCurrentLocation != null) {
            Toast.makeText(applicationContext, "Lat: " + mCurrentLocation!!.latitude
                    + ", Lng: " + mCurrentLocation!!.longitude, Toast.LENGTH_LONG).show()

            val geocoder: Geocoder = Geocoder(this, Locale.getDefault())
            val addresses: List<Address>

            addresses = geocoder.getFromLocation(mCurrentLocation!!.latitude, mCurrentLocation!!.longitude, 1) // Here 1 represent max location result to returned, by documents it recommended 1 to 5

            val address = addresses[0].getAddressLine(0) // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()

            val city = addresses[0].locality
            val state = addresses[0].adminArea
            val country = addresses[0].countryName
            val postalCode = addresses[0].postalCode
            val knownName = addresses[0].featureName

            Toast.makeText(this, "address = $address city = $city country = $country " +
                    "postalCode = $postalCode knownName = $knownName", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(applicationContext, "Last known location is not available!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        when (requestCode) {
        // Check for the integer request code originally supplied to startResolutionForResult().
            REQUEST_CHECK_SETTINGS -> when (resultCode) {
                Activity.RESULT_OK -> Log.e(TAG, "User agreed to make required location settings changes.")
                Activity.RESULT_CANCELED -> {
                    Log.e(TAG, "User chose not to make required location settings changes.")
                    mRequestingLocationUpdates = false
                }
            }// Nothing to do. startLocationupdates() gets called in onResume again.
        }
    }

    private fun openSettings() {
        val intent = Intent()
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        val uri = Uri.fromParts("package",
                BuildConfig.APPLICATION_ID, null)
        intent.data = uri
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()

        // Resuming location updates depending on button state and
        // allowed permissions
        if (mRequestingLocationUpdates!! && checkPermissions()) {
            startLocationUpdates()
        }

        updateLocationUI()
    }

    private fun checkPermissions(): Boolean {
        val permissionState = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
        return permissionState == PackageManager.PERMISSION_GRANTED
    }

    override fun onPause() {
        super.onPause()

        if (mRequestingLocationUpdates!!) {
            // pausing location updates
            stopLocationUpdates()
        }
    }

}
