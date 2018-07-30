package service;

import pojo.Customer;

import java.util.List;

public interface CustomerManager {
	public Customer registCustomer(Customer c);

	public Customer updateCustomer(Customer c);

	public void delete(String id);

	public List<Customer> findAllCustomers();
}
