package com.boiler.plate.code.base

import android.annotation.SuppressLint
import android.app.ActivityOptions
import androidx.fragment.app.Fragment
import com.boiler.plate.code.data.entities.EmployeeData

open class BaseFragment: Fragment() {

    @SuppressLint("NewApi")
    protected fun navigateToMovieDetailsScreen(movie: EmployeeData) {
        var activityOptions: ActivityOptions? = null
        activity?.overridePendingTransition(0, 0)
    }
}