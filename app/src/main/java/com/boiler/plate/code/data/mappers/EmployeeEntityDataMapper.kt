package com.boiler.plate.code.data.mappers

import com.boiler.plate.code.data.api.EmployeeResponse
import com.boiler.plate.code.data.entities.EmployeeData
import com.boiler.plate.code.domain.Mapper

import javax.inject.Inject

//@Singleton
class EmployeeEntityDataMapper @Inject
constructor() : Mapper<EmployeeResponse, EmployeeData>() {

    override fun mapFrom(from: EmployeeResponse): EmployeeData {
        return EmployeeData(
                id = from.id,
                profileImage = from.profile_image,
                address = from.address,
                website = from.website,
                phone = from.phone,
                username = from.name,
                company = from.company,
                email = from.email

        )
    }
}


