package ru.r3tam.roompet.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_CARD = "CARD"
@Entity(tableName = TABLE_CARD)
data class Card(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long
)