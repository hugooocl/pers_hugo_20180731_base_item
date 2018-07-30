package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import pojo.Customer;
import service.CustomerManager;

import java.util.List;

@Service
public class CustomerManagerImpl implements CustomerManager{
	@Autowired
	private CustomerDao customerDao;
	@Transactional
	@Override
	public Customer registCustomer(Customer c) {
		return customerDao.addCustomer(c);
	}
	@Transactional
	@Override
	public Customer updateCustomer(Customer c) {
		return customerDao.update(c);
	}
	@Transactional
	@Override
	public void delete(String id) {
		customerDao.delete(id);
	}
	@Transactional
	@Override
	public List<Customer> findAllCustomers() {
		return customerDao.findAllCustomers();
	}
}
