package com.boiler.plate.code.data.db

import androidx.room.TypeConverter
import java.math.BigDecimal
import java.util.*

class Converter{
    companion object{
        @TypeConverter
        @JvmStatic
        fun fromBigDecimal(value:BigDecimal):String{
            return value.toString()
        }

        @TypeConverter
        @JvmStatic
        fun toBigDecimal(value:String):BigDecimal{
            return value.toBigDecimal()
        }

        @TypeConverter
        @JvmStatic
        fun toDate(value:Long):Date{
            //If your result always returns 1970, then comment this line
            //val date =  Date(value)

            //If your result always returns 1970, then uncomment this line
            val date = Date(value*1000L)

            return date
        }

        @TypeConverter
        @JvmStatic
        fun fromDate(date:Date):Long{
            return date.time
        }
    }
}