package com.boiler.plate.code.presentation.ui.employeeDetails.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.api.load
import com.boiler.plate.code.R
import com.boiler.plate.code.common.CONSTANTS
import com.boiler.plate.code.data.entities.EmployeeData
import kotlinx.android.synthetic.main.activity_movie_details.*

class EmployeeDetailsActivity : AppCompatActivity() {


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_movie_details)
            val ss:EmployeeData = intent.getParcelableExtra(CONSTANTS.MOVIE_ID)
            ss.profileImage?.let {
                posterimage.load(it)
            }
            ss.email?.let {
                email.text=it
            }
            ss.username?.let {
                name.text=it
            }
            ss.website?.let {
                website.text=it
            }
            ss.company?.name?.let {
                website.text=it
            }
            ss.company?.catchPhrase?.let {
                company_detail.text=it
            }
            ss.phone?.let {
                phone.text=it
            }




        }
}