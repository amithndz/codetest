package com.boiler.plate.code.presentation.ui.Employee.activities

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import com.boiler.plate.code.R
import com.boiler.plate.code.presentation.ui.Employee.fragments.EMPLOYEE_LIST_FRAGMENT_TAG
import com.boiler.plate.code.presentation.ui.Employee.fragments.EmployeeListFragment
import com.boiler.plate.code.presentation.ui.Employee.fragments.newMovieListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var searchView: SearchView
    private lateinit var fragment: EmployeeListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragment= newMovieListFragment()
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container,fragment , EMPLOYEE_LIST_FRAGMENT_TAG)
                        .commitNow()
                title = getString(R.string.popular)
            }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.main, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager?
        searchView = menu!!.findItem(R.id.action_search)
                .actionView as SearchView
        searchView.setSearchableInfo(searchManager
                ?.getSearchableInfo(getComponentName()))
        searchView.setMaxWidth(Int.MAX_VALUE)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override  fun onQueryTextSubmit(query: String?): Boolean {
                fragment.getListAdapter().getFilter()?.filter(query)
                return false
            }

            override  fun onQueryTextChange(query: String?): Boolean {
                fragment.getListAdapter().getFilter()?.filter(query)
                return false
            }
        })
               return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_search) {
            true
        } else super.onOptionsItemSelected(item)
    }
}


