package com.restapi.demo.service;

import com.restapi.demo.entity.Customer;
import com.restapi.demo.entity.Post;
import com.restapi.demo.exception.CustomerNotFoundException;
import com.restapi.demo.exception.PostNotValidException;
import com.restapi.demo.jparepo.CustomerRepository;
import dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    CustomerRepository customerRepository;



    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;


    }

   public CustomerDTO addCustomer(CustomerDTO customerDTO) {

        Customer customerEntity = new Customer(customerDTO.getId(), customerDTO.getName());

        customerRepository.save(customerEntity);

        return new CustomerDTO(customerEntity.getId(),customerEntity.getName());
    }

    public List<Customer> retrieveAllCustomer() {
        return customerRepository.findAll();
    }

    public void updateCustomer(int customerId, CustomerDTO customerDTO) {

        Optional<Customer> existingCourse = customerRepository.findById(customerId);

        if(existingCourse.isPresent()){
            Customer c = existingCourse.get();
            c.setName(customerDTO.getName());
            customerRepository.save(c);
        } else{
            throw new CustomerNotFoundException("No course Found for the given id:" + customerId);
        }
    }

    public void deleteCustomerById(int customerId) {

        Optional<Customer> existingCourse=customerRepository.findById(customerId);

        if(existingCourse.isPresent()){
                customerRepository.deleteById(customerId);

        }else{
            throw new CustomerNotFoundException("No course Found for the given id: "+customerId );
        }
    }

    public Optional<Customer> findCustomerById(int customerId) {

        Optional<Customer> existingCustomer=customerRepository.findById(customerId);

        if(existingCustomer.isPresent()){
            return customerRepository.findById(customerId);

        }else{
            throw new CustomerNotFoundException("No Customer Found for the given id: "+customerId );
        }
    }
}
