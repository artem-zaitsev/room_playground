package ru.r3tam.roompet.repo.customer

import androidx.annotation.WorkerThread
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import ru.r3tam.roompet.data.dao.CustomerDao
import ru.r3tam.roompet.data.entity.Customer

/**
 * Рнерозиторий для работы с клиентом
 */
class CustomerRepo(
    private val customerDao: CustomerDao
) {

    val customers = customerDao.selectAllCustomers()
    var dummyUid: Int = customers.value?.last()?.uid?.toIntOrNull() ?: 0

    suspend fun createCustomer(name: String) {
        //todo создаем карту для клиента
//        CoroutineScope(Dispatchers.IO).async {
//
//        }
        insert(Customer(dummyUid++.toString(), name))
    }

    suspend fun getCustomerByName(name: String): Customer =
        customerDao.getCustomer(name)

    //todo доделать или убрать + проверить
    suspend fun getCustomerId(name: String): Long {
        val customer = CoroutineScope(Dispatchers.IO).async {
            getCustomerByName(name)
        }
        return customer.await().uid.toLong()
    }

    @WorkerThread
    private fun insert(customer: Customer) {
        customerDao.insert(customer)
    }
}