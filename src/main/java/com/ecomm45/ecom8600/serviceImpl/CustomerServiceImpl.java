package com.ecomm45.ecom8600.serviceImpl;

import com.ecomm45.ecom8600.dto.Request.CreateCustomerRequest;
import com.ecomm45.ecom8600.dto.Response.CustomerResponse;
import com.ecomm45.ecom8600.entity.Customer;
import com.ecomm45.ecom8600.entity.Order;
import com.ecomm45.ecom8600.entity.Users;
import com.ecomm45.ecom8600.repository.CustomerRepository;
import com.ecomm45.ecom8600.repository.OrderRepository;
import com.ecomm45.ecom8600.repository.UsersRepository;
import com.ecomm45.ecom8600.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponse createCustomer(CreateCustomerRequest request) {

        Customer customer = new Customer();

        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setAddress(request.getAddress());
        customer.setCity(request.getCity());
        customer.setCountry(request.getCountry());
        customer.setPhone(request.getPhone());
        customer.setState(request.getState());
        customer.setEmail(request.getEmail());

        Customer savedCustomer = customerRepository.save(customer);

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setFirstName(savedCustomer.getFirstName());
        customerResponse.setLastName(savedCustomer.getLastName());
        customerResponse.setAddress(savedCustomer.getAddress());
        customerResponse.setCity(savedCustomer.getCity());
        customerResponse.setCountry(savedCustomer.getCountry());
        customerResponse.setPhone(savedCustomer.getPhone());
        customerResponse.setState(savedCustomer.getState());
        customerResponse.setEmail(savedCustomer.getEmail());

        return customerResponse;
    }

    @Override
    public CustomerResponse findCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomerId(customer.getId());
        customerResponse.setFirstName(customer.getFirstName());
        customerResponse.setLastName(customer.getLastName());
        customerResponse.setAddress(customer.getAddress());
        customerResponse.setCity(customer.getCity());
        customerResponse.setCountry(customer.getCountry());
        customerResponse.setPhone(customer.getPhone());
        customerResponse.setState(customer.getState());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setOrderIds(customer.getOrders().stream().map(Order::getId).toList());
        return customerResponse;
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        List<Customer> customer = customerRepository.findAll();

        return customer.stream()
                .map(customers -> {
                    CustomerResponse customerResponse = new CustomerResponse();
                    customerResponse.setCustomerId(customers.getId());
                    customerResponse.setFirstName(customers.getFirstName());
                    customerResponse.setLastName(customers.getLastName());
                    customerResponse.setAddress(customers.getAddress());
                    customerResponse.setCity(customers.getCity());
                    customerResponse.setCountry(customers.getCountry());
                    customerResponse.setPhone(customers.getPhone());
                    customerResponse.setState(customers.getState());
                    customerResponse.setEmail(customers.getEmail());
                    customerResponse.setOrderIds(customers.getOrders().stream().map(Order::getId).toList());
                    return customerResponse;

                })
                .toList();
    }
}
