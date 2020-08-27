package com.cozii.coziiandroid.threestepverification.editprofile

import android.content.ContentValues.TAG
import android.content.Context
import android.location.Geocoder
import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cozii.coziiandroid.threestepverification.editprofile.models.EditProfileFields
import com.cozii.coziiandroid.threestepverification.editprofile.models.EditProfileForm
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.RectangularBounds
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse
import com.google.android.libraries.places.api.net.PlacesClient
import java.util.*


class EditProfileViewModel : ViewModel() {
    private var editProfileForm = EditProfileForm()
    val location = MutableLiveData("")
    var placeList: MutableLiveData<List<String>> = MutableLiveData()
    var placesClient: PlacesClient? = null


    fun getEditProfileForm(): EditProfileForm {
        return editProfileForm
    }

    fun onSaveButtonClick() {
        editProfileForm.onClick()
    }

    fun getEditProfileFields(): MutableLiveData<EditProfileFields> {
        return editProfileForm.getProfileFields()
    }

    val valid = MediatorLiveData<Boolean>().apply {
        addSource(location) {
            setPlacesPredictionList(location)
            value = true
        }
    }

    private fun setPlacesPredictionList(location: MutableLiveData<String>) {
        val token = AutocompleteSessionToken.newInstance()

        val bounds = RectangularBounds.newInstance(
            LatLng(37.0902, 95.7129),
            LatLng(56.1304, 106.3468)
        )

        val request =
            FindAutocompletePredictionsRequest.builder()
                .setLocationBias(bounds)
                .setCountry("ca")
                .setTypeFilter(TypeFilter.ADDRESS)
                .setSessionToken(token)
                .setQuery(location.value)
                .build()

        placesClient!!.findAutocompletePredictions(request)
            .addOnSuccessListener { response: FindAutocompletePredictionsResponse ->
                var places = arrayListOf<String>()
                for (prediction in response.autocompletePredictions) {
                    places.add(prediction.getFullText(null).toString())
                }
                placeList.value = places
            }.addOnFailureListener { exception: Exception? ->
                if (exception is ApiException) {
                    val apiException = exception as ApiException
                    Log.e(TAG, "Place not found: " + apiException.statusCode)
                }
            }
    }

    fun initiatePlacesApi(context: Context,apiKey : String){
        Places.initialize(context, apiKey)
        placesClient = Places.createClient(context)
    }

//    fun hideKeyboardFrom(context: Context, view: View) {
//        val imm: InputMethodManager =
//            context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(view.windowToken, 0)
//    }

    fun splitSelectedAddress(selectedAddress : String) : List<String>{
        return selectedAddress.split(",")
    }

    fun getPostalCode(context: Context,location : String) : String{
        val geocoder = Geocoder(context, Locale.getDefault())
        val addresses = geocoder.getFromLocationName(location,5)
        var postalCode = ""
        for (locationName in addresses){
            if (locationName.countryCode.contains("CA") || locationName.countryCode.contains("US")){
                postalCode = locationName.postalCode
            }
        }
        return postalCode
    }
}