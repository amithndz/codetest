package com.boiler.plate.code.presentation.ui.Employee.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.boiler.plate.code.EmployeeApplication
import com.boiler.plate.code.R
import com.boiler.plate.code.base.BaseFragment
import com.boiler.plate.code.common.CONSTANTS
import com.boiler.plate.code.presentation.ui.employeeDetails.activity.EmployeeDetailsActivity
import kotlinx.android.synthetic.main.fragment_employee_list.*
import javax.inject.Inject


fun newMovieListFragment() = EmployeeListFragment()

val EMPLOYEE_LIST_FRAGMENT_TAG = EmployeeListFragment::class.java.name

class EmployeeListFragment : BaseFragment() {

    @Inject
    lateinit var factory: EmployeeVMFactory
    private lateinit var viewModel: EmployeeViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var employeeAdapter: EmployeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       (activity?.application as EmployeeApplication).createPopularComponenet().inject(this)
        initViewModel()
        if (savedInstanceState == null) {
            viewModel.getPopularMovies()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_employee_list, container, false)
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.viewState.observe(this, Observer {
            if (it != null) handleViewState(it)
        })
        viewModel.errorState.observe(this, Observer { throwable ->
            throwable?.let {
                Toast.makeText(activity, throwable.message, Toast.LENGTH_LONG).show()

            }
        })
    }




    private fun handleViewState(state: EmployeeViewState) {
        progressBar.visibility = if (state.showLoading) View.VISIBLE else View.GONE
        state.employee?.let { employeeAdapter.addMovies(it) }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = employee_progress
        employeeAdapter = EmployeeAdapter { movie, view ->

            navigateToMovieDetailsScreen(movie)

            val i = Intent(context, EmployeeDetailsActivity::class.java)
            i.putExtra(CONSTANTS.MOVIE_ID, movie)
            startActivity(i);

        }
        recyclerView = employee_recyclerview
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        recyclerView.adapter = employeeAdapter
    }


    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, factory).get(EmployeeViewModel::class.java)

    }
    override fun onDestroy() {
        super.onDestroy()
        (activity?.application as EmployeeApplication).releasePopularComponent()
    }

    fun getListAdapter(): EmployeeAdapter {

        return  employeeAdapter;

    }

}
