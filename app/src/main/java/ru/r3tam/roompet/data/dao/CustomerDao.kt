package ru.r3tam.roompet.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.r3tam.roompet.data.entity.Customer
import ru.r3tam.roompet.data.entity.TABLE_CUSTOMER

/**
 * Data Access Object для работы с таблицей клиентов
 */
@Dao
interface CustomerDao {

    @Insert
    fun insert(customer: Customer)

    @Update
    fun update(customer: Customer)

    @Delete
    fun delete(customer: Customer)

    @Query("SELECT * FROM $TABLE_CUSTOMER")
    fun selectAllCustomers(): LiveData<List<Customer>>

    @Query("SELECT * FROM $TABLE_CUSTOMER WHERE uid = :id")
    fun selectCustomerById(id: Int): LiveData<Customer>
}