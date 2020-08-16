package com.boiler.plate.code.data.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address(
	val zipcode: String? = null,
	val suite: String? = null,
	val city: String? = null,
	val street: String? = null
) : Parcelable
