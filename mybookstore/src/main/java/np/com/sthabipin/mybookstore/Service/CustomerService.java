package np.com.sthabipin.mybookstore.Service;

import java.util.List;

import np.com.sthabipin.mybookstore.model.Customer;

public interface CustomerService {

	public void addCustomer(Customer customer);
	
	Customer getCustomerById(int customerId);
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerByUsername(String username);
}
