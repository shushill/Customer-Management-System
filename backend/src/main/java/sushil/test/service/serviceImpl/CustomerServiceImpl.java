package sushil.test.service.serviceImpl;


import org.springframework.stereotype.Service;
import sushil.test.controller.CustomerController;
import sushil.test.entity.Customer;
import sushil.test.exception.ResourceNotFoundException;
import sushil.test.repository.CustomerRepo;
import sushil.test.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer createCustomer(Customer customer){


        Customer newCustomer = customerRepo.save(customer);

        return newCustomer;
    }

    public List<Customer> createMultipleCustomer(List<Customer> customer){
        List<Customer> newCustomerListData = customerRepo.saveAll(customer);
        return newCustomerListData;
    }
    @Override
    public List<Customer> getAllCustomer(){

        List<Customer> listOfCustomerData = customerRepo.findAll();

        return listOfCustomerData;


    }

    @Override
    public Customer getCustomerById(long id){
        Customer newDataCustomer = customerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        return newDataCustomer;
    }


    @Override
    public Customer updateCustomer(Long id, Customer customer){

        Customer newDataCustomer = customerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));

        newDataCustomer.setEmail(customer.getEmail());
        newDataCustomer.setAddress(customer.getAddress());
        newDataCustomer.setName(customer.getName());
        newDataCustomer.setAccountManager(customer.getAccountManager());
        newDataCustomer.setAudit(customer.getAudit());
        newDataCustomer.setPhone(customer.getPhone());
        newDataCustomer.setCustomerStatus(customer.getCustomerStatus());

        customerRepo.save(newDataCustomer);

        return newDataCustomer;

    }

    public List<Customer> updateMultipleCustomer(List<Customer> customers){

        List<Customer> newList = new ArrayList<>();

        for(Customer customer : customers){
            Optional<Long> opt = Optional.ofNullable(customer.getCustomerId());
            Customer newData;
            if(opt.isPresent() && opt.get()!=0){
                long id = opt.get();
                newData = updateCustomer(id, customer);
            }
            else{
                newData = createCustomer(customer);
            }
            newList.add(newData);
        }
        return newList;

    }

    @Override
    public void deleteCustomerById(Long id){
        Customer newDataCustomer = customerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customerRepo.delete(newDataCustomer);
    }

}
