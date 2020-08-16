package com.boiler.plate.code.presentation.ui.Employee.fragments

import androidx.lifecycle.MutableLiveData
import com.boiler.plate.code.base.BaseViewModel
import com.boiler.plate.code.common.SingleLiveEvent
import com.boiler.plate.code.domain.EmployeeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class EmployeeViewModel
@Inject constructor(
        private val employeeRepository: EmployeeRepository) : BaseViewModel() {
    var viewState: MutableLiveData<EmployeeViewState> = MutableLiveData()
    var errorState: SingleLiveEvent<Throwable?> = SingleLiveEvent()
    init {
        viewState.value = EmployeeViewState()
    }

    fun getPopularMovies() {
        addDisposable(employeeRepository.getMovies().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ movies ->
                    viewState.value?.let {
                        val newState = this.viewState.value?.copy(showLoading = false, employee = movies)
                        this.viewState.value = newState
                        this.errorState.value = null
                    }

                }, {
                    viewState.value = viewState.value?.copy(showLoading = false)
                    errorState.value = it
                }))
    }

}