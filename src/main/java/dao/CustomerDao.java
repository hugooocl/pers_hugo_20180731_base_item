package dao;

import pojo.Customer;

import java.util.List;

public interface CustomerDao {
    public Customer addCustomer(Customer c);

    public void delete(String id);

    public Customer update(Customer c);

    public List<Customer> findAllCustomers();
}
