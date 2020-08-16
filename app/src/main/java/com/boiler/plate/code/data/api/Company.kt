package com.boiler.plate.code.data.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Company(
	val bs: String? = null,
	val catchPhrase: String? = null,
	val name: String? = null
) : Parcelable
