package sushil.test.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sushil.test.entity.Customer;
import sushil.test.service.CustomerService;

import jakarta.validation.Valid;
import sushil.test.utility.CustomerList;

import java.util.List;


@Tag(
        name = "Customer Management service CRUD operations",
        description = "CRUD Rest API  \n CRUD Operations: Endpoints for creating, retrieving, updating, and deleting customers.\n" +
                "Bulk Load: POST /customers/bulk-load for importing multiple customer records.\n" +
                "Bulk Update: PUT /customers/bulk-update for updating multiple records at once.\n"
)
@RestController
@RequestMapping("api/v1")
@Validated
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createACustomer(@Valid @RequestBody Customer customer){
        Customer newCustomerData = customerService.createCustomer(customer);

        return new ResponseEntity<>(newCustomerData, HttpStatus.CREATED);
    }



    @PostMapping("/multiple/customer")
    public ResponseEntity<CustomerList> createMultipleCustomerList( @Valid @RequestBody CustomerList customerList){
        List<Customer> customers = customerList.getCustomers();



        List<Customer> newCustomerData = customerService.createMultipleCustomer(customers);
        CustomerList newData = new CustomerList();
        newData.setCustomers(newCustomerData);

        return new ResponseEntity<>(newData, HttpStatus.CREATED);
    }

    @PutMapping ("/multiple/customer")
    public ResponseEntity<CustomerList> updateMultipleCustomerList( @Valid @RequestBody CustomerList customerList){
        List<Customer> customers = customerList.getCustomers();

        List<Customer> newCustomerData = customerService.updateMultipleCustomer(customers);
        CustomerList newData = new CustomerList();
        newData.setCustomers(newCustomerData);

        return new ResponseEntity<>(newData, HttpStatus.CREATED);
    }



    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomerData(){
        List<Customer> lsData = customerService.getAllCustomer();

        return new ResponseEntity<>(lsData, HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerByIdData(@PathVariable long id){
        Customer newData = customerService.getCustomerById(id);
        return new ResponseEntity<>(newData, HttpStatus.OK);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updatePostByIdData(@PathVariable long id, @Valid @RequestBody Customer customer){
        Customer newData = customerService.updateCustomer(id, customer);
        return new ResponseEntity<>(newData, HttpStatus.OK);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustomerIdData(@PathVariable long id){
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>("Customer data deleted successfully.", HttpStatus.OK);

    }


}

