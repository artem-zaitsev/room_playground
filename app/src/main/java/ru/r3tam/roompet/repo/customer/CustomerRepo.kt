package ru.r3tam.roompet.repo.customer

import androidx.annotation.WorkerThread
import ru.r3tam.roompet.data.dao.CustomerDao
import ru.r3tam.roompet.data.entity.Customer

/**
 * Рнерозиторий для работы с клиентом
 */
class CustomerRepo(
    private val customerDao: CustomerDao
){

    val customers = customerDao.selectAllCustomers()
    var dummyUid: Int = customers.value?.last()?.uid?.toIntOrNull() ?: 0

    suspend fun createCustomer(name: String) {
        //todo создаем карту для клиента
        insert(Customer(dummyUid++.toString(), name))
    }

    @WorkerThread
    private fun insert(customer: Customer) {
        customerDao.insert(customer)
    }
}