package com.boiler.plate.code.presentation.ui.Employee.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.boiler.plate.code.R
import com.boiler.plate.code.data.entities.EmployeeData
import kotlinx.android.synthetic.main.employee_item_row.view.*


class EmployeeAdapter constructor(private val onEmployeeSelected:
                                       (EmployeeData, View) -> Unit) :
        RecyclerView.Adapter<EmployeeAdapter.EmployeeCellViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeCellViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.employee_item_row,
                parent,
                false)
        return EmployeeCellViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeCellViewHolder, position: Int) {
        val movie = Employees[position]
        holder.bind(movie, onEmployeeSelected)
    }

    private val Employees: MutableList<EmployeeData> = mutableListOf()
    private var EmployeeListFiltered: MutableList<EmployeeData> = mutableListOf()


    override fun getItemCount(): Int {
        return EmployeeListFiltered.size
    }
    fun getFilter(): Filter? {
        return object : Filter() {
            protected override fun performFiltering(charSequence: CharSequence): FilterResults? {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    EmployeeListFiltered = Employees
                } else {
                    val filteredList: MutableList<EmployeeData> = ArrayList()
                    for (employee in Employees) {
                        if (employee.username!!.toLowerCase().contains(charString.toLowerCase())||employee.email!!.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(employee)
                        }
                    }
                    EmployeeListFiltered = filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = EmployeeListFiltered
                return filterResults
            }

            protected override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
                EmployeeListFiltered = filterResults.values as MutableList<EmployeeData>
                notifyDataSetChanged()
            }
        }
    }


    fun addMovies(movies: List<EmployeeData>) {
        this.Employees.addAll(movies)
        EmployeeListFiltered=this.Employees
        notifyDataSetChanged()
    }


    class EmployeeCellViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(employee: EmployeeData, listener: (EmployeeData, View) -> Unit) = with(itemView) {


            title.text = employee.username
            company.text = employee.company?.name
            employee.profileImage?.let {
                image.load(it)
            }


            setOnClickListener { listener(employee, itemView) }
        }

    }
}