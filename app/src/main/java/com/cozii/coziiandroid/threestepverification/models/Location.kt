package com.cozii.coziiandroid.threestepverification.models

import com.google.android.libraries.places.api.model.Place

data class Location(val id : Place.Field, val name : Place.Field, val address : Place.Field) {
}