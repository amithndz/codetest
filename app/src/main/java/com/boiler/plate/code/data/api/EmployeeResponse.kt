package com.boiler.plate.code.data.api

data class EmployeeResponse(
	val profile_image: String? = null,
	val website: String? = null,
	val address: Address? = null,
	val phone: String? = null,
	val name: String? = null,
	val company: Company? = null,
	val id: Int = 0,
	val email: String? = null,
	val username: String? = null
)
