package ru.r3tam.roompet.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.r3tam.roompet.data.entity.Card
import ru.r3tam.roompet.data.entity.Customer
import ru.r3tam.roompet.data.entity.TABLE_CARD
import ru.r3tam.roompet.data.entity.TABLE_CUSTOMER

/**
 * Data Access Object для работы с таблицей карт
 */
@Dao
interface CardDao {

    @Insert
    fun insert(card: Card)

    @Update
    fun update(card: Card)

    @Delete
    fun delete(card: Card)

    @Query("SELECT * FROM $TABLE_CARD")
    fun selectAllCard(): LiveData<List<Card>>

    @Query("SELECT * FROM $TABLE_CARD WHERE id = :id")
    fun selectCardById(id: Long): LiveData<Card>
}