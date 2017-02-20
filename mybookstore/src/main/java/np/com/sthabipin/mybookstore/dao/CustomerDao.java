package np.com.sthabipin.mybookstore.dao;

import java.util.List;

import np.com.sthabipin.mybookstore.model.Customer;

public interface CustomerDao {

	public void addCustomer(Customer customer);
	
	Customer getCustomerById(int customerId);
	
	List<Customer> getAllCustomers();

	public Customer getCustomerByUsername(String username);
}
