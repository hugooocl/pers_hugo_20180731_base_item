package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.CustomerDao;
import pojo.Customer;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @PersistenceContext(name = "em")
    private EntityManager manager;

    @Override
    public Customer addCustomer(Customer c) {
        manager.persist(c);
        return c;
    }

    public void delete(String id) {
        Customer c = manager.getReference(Customer.class, id);
        manager.remove(c);
    }

    public Customer update(Customer c) {
        Customer c1 = manager.merge(c);
        return c1;
    }

    public List<Customer> findAllCustomers() {
        String jpql = "from Customer";
        List<Customer> customers = manager
                .createQuery(jpql)
                .getResultList();
        return customers;
    }
}
