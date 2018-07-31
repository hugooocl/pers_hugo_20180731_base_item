package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.Customer;
import pojo.ErrorMessage;
import service.CustomerManager;

import javax.persistence.PersistenceException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerManager customerManager;

    @RequestMapping(method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer c) {


        return customerManager.registCustomer(c);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Customer updateCustomer(@RequestBody Customer c) {
        return customerManager.updateCustomer(c);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable String id) {
        customerManager.delete(id);
        return "{}";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> findAllCustomer() {
        return customerManager.findAllCustomers();
    }


    @ResponseBody
    @ExceptionHandler(value = PersistenceException.class)
    public Map<String, ErrorMessage> handlePresistenceExcpetion(Exception e) {
        Map<String, ErrorMessage> map = new HashMap<String, ErrorMessage>();

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode("409");
        errorMessage.setReason("object already deleted");
        map.put("error", errorMessage);
        return map;
    }


}
