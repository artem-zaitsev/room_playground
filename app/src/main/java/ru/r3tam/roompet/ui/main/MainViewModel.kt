package ru.r3tam.roompet.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.r3tam.roompet.data.db.AppDatabase
import ru.r3tam.roompet.data.entity.Customer
import ru.r3tam.roompet.repo.customer.CustomerRepo
import kotlin.coroutines.CoroutineContext

class MainViewModel(app: Application) : AndroidViewModel(app), CoroutineScope {
    override val coroutineContext: CoroutineContext  = Dispatchers.IO

    private val customerRepo: CustomerRepo
    val allCustomers: LiveData<List<Customer>>

    init {
        val customerDao = AppDatabase.getDatabase(app).customerDao()
        customerRepo = CustomerRepo(customerDao)
        allCustomers = customerRepo.customers
    }

    fun createNewCustomer(name: String) = launch {
        customerRepo.createCustomer(name)
    }
}
