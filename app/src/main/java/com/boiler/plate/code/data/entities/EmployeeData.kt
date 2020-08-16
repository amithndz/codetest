package com.boiler.plate.code.data.entities

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.boiler.plate.code.data.api.Address
import com.boiler.plate.code.data.api.Company
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


/**
 * Created by Yossi Segev on 11/11/2017.
 */
@Entity(tableName = "employee")
@Parcelize
data class EmployeeData(

        @SerializedName("id")
        @PrimaryKey
        var id: Int = -1,


        @Embedded
        var address: Address?,


        @Embedded
        var company: Company?,

        @SerializedName("profileImage")
        var profileImage: String? = "",

        @SerializedName("website")
        var website: String? = "",

        @SerializedName("phone")
        var phone: String? = "",

        @SerializedName("email")
        var email: String? = "",

        @SerializedName("username")
        var username: String?


) : Parcelable