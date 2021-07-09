package com.geetha.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllTopics();
    }

    @RequestMapping("/customers")
    public List<Customer> getCustomerByLastName(@RequestParam(value = "lastName", required = true) String LastName) {
        return customerService.getCustomerByLastName(LastName);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/customer")
    public void addCustomer(@RequestParam(value = "id", required = true) Long Id,
                            @RequestParam(value = "firstName", required = true) String FirstName,
                            @RequestParam(value = "lastName", required = true) String LastName,
                            @RequestParam(value = "emailId", required = true) String EmailId) {
        Customer customer = new Customer(Id, FirstName, LastName, EmailId);
        customerService.addCustomer(customer);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/customer")
    public void updateCustomer(@RequestParam(value = "id", required = true) Long Id,
                            @RequestParam(value = "firstName", required = true) String FirstName,
                            @RequestParam(value = "lastName", required = true) String LastName,
                            @RequestParam(value = "emailId", required = true) String EmailId) {
        Customer customer = new Customer(Id, FirstName, LastName, EmailId);
        customerService.addCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customer")
    public void deleteCustomer(@RequestParam(value = "id", required = true) Long Id) {
        customerService.deleteCustomer(Id);
    }
}
