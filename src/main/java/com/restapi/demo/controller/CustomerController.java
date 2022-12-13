package com.restapi.demo.controller;

import com.restapi.demo.entity.Customer;
import com.restapi.demo.service.CustomerService;
import dto.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/customers")
@Validated
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CustomerDTO addCourse(@RequestBody @Valid CustomerDTO customerDTO){

        return customerService.addCustomer(customerDTO);
    }

    @GetMapping
    List<Customer> retrieveAllCourses(){
        return customerService.retrieveAllCustomer();
    }

    @PutMapping("/{course_id}")
    void updateCourse(@RequestBody CustomerDTO customerDTO, @PathVariable ("course_id") int userId){

        customerService.updateCustomer(userId, customerDTO);
    }

    @DeleteMapping("/{customer_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCourseById(@PathVariable("customer_id") int customerId){
        customerService.deleteCustomerById(customerId);
    }

    @GetMapping("/{customer_id}")
    Optional<Customer> findCustomerById(@PathVariable("customer_id") int customerId){

        return customerService.findCustomerById(customerId);
    }


}
