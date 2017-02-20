package np.com.sthabipin.mybookstore.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import np.com.sthabipin.mybookstore.Service.CustomerService;
import np.com.sthabipin.mybookstore.dao.CustomerDao;
import np.com.sthabipin.mybookstore.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public void addCustomer(Customer customer) {
		
		customerDao.addCustomer(customer);

	}

	@Override
	public Customer getCustomerById(int customerId) {
		
		return customerDao.getCustomerById(customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		
		return customerDao.getCustomerByUsername(username);
	}

}
