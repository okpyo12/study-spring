package Customer.example.demo.User

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.convert.Delimiter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController {
    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping("/customers", produces = ["application/json"])
    fun getCustomers(@RequestParam(
        required = false,
        defaultValue = ""
    )name: String): ResponseEntity<List<Customer?>> = ResponseEntity
        .ok()
        .body(customerService.searchCustomers(name))

    @GetMapping("/customer/{id}", produces = ["application/json"])
    fun getCustomer(@PathVariable id:Int) = ResponseEntity
        .ok()
        .body(customerService.getCustomer(id))

    @PostMapping("/customer")
    fun createCustomer(@RequestBody customer:Customer): ResponseEntity<Any> {
        customerService.createCustomer(customer)
        return ResponseEntity
            .ok()
            .body(true)
    }

    @DeleteMapping("/customer/{id}")
    fun deleteCustomer(@PathVariable id:Int): ResponseEntity<Any>{
        if (customerService.getCustomer(id) != null) {
            customerService.deleteCustomer(id)
            return ResponseEntity
                .ok()
                .build()
        }
        throw NotFoundException("customer", "customer id: $id")
    }

    @PutMapping("/customer/{id}")
    fun updateCustomer(
        @PathVariable id:Int,
        @RequestBody customer:Customer
    ): ResponseEntity<Any> {
        if (customerService.getCustomer(id) != null) {
            customerService.updateCustomer(id,customer)
            return ResponseEntity
                .ok()
                .body(true)
        }
        throw NotFoundException("customer", "customer id: $customer.id")
    }
}

class NotFoundException(s: String, s1: String) : Throwable() {

}
