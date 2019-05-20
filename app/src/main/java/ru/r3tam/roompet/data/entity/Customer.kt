package ru.r3tam.roompet.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_CUSTOMER = "CUSTOMER"

@Entity(tableName = TABLE_CUSTOMER)
data class Customer(
    @PrimaryKey @ColumnInfo(name = "uid") val uid: String,
    @ColumnInfo var name: String,
    @ColumnInfo var cardId: Long? = null
)