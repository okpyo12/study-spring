package Customer.example.demo.User

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class CustomerServiceImpl : CustomerService {
    companion object {
        val initialCustomers = arrayOf(
            Customer(1,"Kotlin"),
            Customer(2,"Lotlin"),
            Customer(3,"Jotlin")
        )
    }

    val customers = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))

    override fun getCustomer(id: Int) = customers[id]

    override fun createCustomer(customer: Customer) {customers[customer.id] = customer}

    override fun deleteCustomer(id: Int) {customers.remove(id)}

    override fun updateCustomer(id: Int, customer: Customer) {customers[customer.id] = customer}

    override fun searchCustomers(name: String): List<Customer> = customers
        .filter{it.value.name.contains(name, true)}
        .map(Map.Entry<Int,Customer>::value).toList()
}